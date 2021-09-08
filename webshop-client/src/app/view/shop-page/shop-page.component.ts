import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilterParams, Product, SortParams } from 'src/app/model/shop.model';
import { ShopService } from 'src/app/service/shop.service';

@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.css']
})
export class ShopPageComponent implements OnInit {

  products: Product[] = [];
  sortSelection: String = 'name asc';
  maxPrice: number = 0;
  minPrice: number = 0;
  maxHeight: number = 0;
  minHeight: number = 0;
  filterParams: FilterParams = {items: this.products, heightFrom: this.minHeight, heightTo: this.maxHeight
                                                    , priceFrom: this.minPrice, priceTo: this.maxPrice}
  searchInput: String = '';

  constructor(private shopService: ShopService, private router: Router) { }

  ngOnInit(): void {
      //initalize loader
      this.shopService.getProducts().toPromise().then( resp => {
        this.products = resp;
        this.calculateFilters();
        this.filterParams = {items: this.products, heightFrom: this.minHeight, heightTo: this.maxHeight
          , priceFrom: this.minPrice, priceTo: this.maxPrice}
      })
      //close loader
  }

  getDetails(id: number){
    const url = '/product-details?id=' + id;
    this.router.navigateByUrl(url)
  }

  selectionChanged(event: any){
    this.sortSelection = event.target.value;
    this.sortProducts(this.products);
  }

  searchProducts(){
    this.shopService.searchProducts({input: this.searchInput}).toPromise().then( response => {
      this.filterProducts(response);
    })
  }

  sortProducts(items: Product[]){
    let param = this.sortSelection.split(' ')[0];
    let type = this.sortSelection.split(' ')[1];
    let sortParams: SortParams = {type: type, param: param, items: items};
    this.shopService.sortProducts(sortParams).toPromise().then( response => {
      this.products = response;
    })
  }

  calculateFilters(){
    this.products.forEach( element => {
      element.price > this.maxPrice ? this.maxPrice = element.price : '';
      element.price < this.minPrice ? this.minPrice = element.price : '';
      element.height > this.maxHeight ? this.maxHeight = element.height : '';
      element.height < this.minHeight ? this.minHeight = element.height : '';
    })
  }

  filterProducts(items: Product[]){
    this.filterParams.items = items;
    this.shopService.filterProducts(this.filterParams).toPromise().then( response => {
      this.sortProducts(response);
    })
  }


}
