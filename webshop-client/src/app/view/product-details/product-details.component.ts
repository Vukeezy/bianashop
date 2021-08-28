import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/model/shop.model';
import { ShopService } from 'src/app/service/shop.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  product?: Product;
  length: number = 1;
  currentPrice: number = 0;
  showedPicture: String = '';

  constructor(private route: ActivatedRoute, private shopService: ShopService, public router: Router) { }

  ngOnInit(): void {
    let id: number = Number(this.route.snapshot.queryParamMap.get('id')) || 0;
    this.shopService.getProduct(id).toPromise().then( response => {
      this.product = response;
      this.product.mainPicture = this.product.pictures[0]
      this.currentPrice = this.product.price * this.length;
      this.showedPicture = this.product.mainPicture;
    })
  }

  onLengthChange(newLength: any){
    this.length = Number(newLength['target']['value'])
    this.currentPrice = this.length * (this.product?.price || 0);
  }

  pictureChanged(newPicture: any){
    this.showedPicture = newPicture;
  }

  addProduct() {
    var elem = document.getElementById('overlay');
    elem ? elem.style.display = "block" : '';
    this.shopService.addItemToCart({id: (this.product?.id || 0), amount: this.length})
  }
  
  overlayOff() {
    var elem = document.getElementById('overlay');
    elem ? elem.style.display = "none" : '';
    this.router.navigateByUrl('/checkout');
  }

}
