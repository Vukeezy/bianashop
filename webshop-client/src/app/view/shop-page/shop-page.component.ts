import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product, SortParams } from 'src/app/model/shop.model';
import { ShopService } from 'src/app/service/shop.service';

@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.css']
})
export class ShopPageComponent implements OnInit {

  products: Product[] = [];
  sortSelection: String = 'name asc';

  constructor(private shopService: ShopService, private router: Router) { }

  ngOnInit(): void {
      //initalize loader
      this.shopService.getProducts().toPromise().then( resp => {
        this.products = resp;
        this.products.forEach(element => {
          element.mainPicture = element.pictures[0] || null;
        });
      })
      //close loader
  }

  getDetails(id: number){
    const url = '/product-details?id=' + id;
    this.router.navigateByUrl(url)
  }

  selectionChanged(event: any){
    this.sortSelection = event.target.value;
    let param = this.sortSelection.split(' ')[0];
    let type = this.sortSelection.split(' ')[1];
    let sortParams: SortParams = {type: type, param: param, items: this.products};
    this.shopService.sortProducts(sortParams).toPromise().then( response => {
      this.products = response;
      this.products.forEach( product => {
        product.mainPicture = product.pictures[0];
      })
    })
  }
}
