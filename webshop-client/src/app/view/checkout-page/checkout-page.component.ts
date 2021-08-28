import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cart, CartItem } from 'src/app/model/shop.model';
import { ShopService } from 'src/app/service/shop.service';

@Component({
  selector: 'app-checkout-page',
  templateUrl: './checkout-page.component.html',
  styleUrls: ['./checkout-page.component.css']
})
export class CheckoutPageComponent implements OnInit {

  cartItems: CartItem[] = [];
  totalPrice: number = 0;
  delievery: boolean = false;
  formData: FormGroup;
  orderNumber: number = 0;

  constructor(private shopService: ShopService, private fb: FormBuilder, public router: Router) { 
    this.formData = fb.group({
      'fullName': ['', Validators.required],
      'address': ['', Validators.required],
      'delievery': this.delievery,
      'email': ['', Validators.required],
      'phoneNumber': ['', Validators.required]
    })
  }

  ngOnInit(): void {
    this.loadCart();
  }

  loadCart(){
    let jsonString = sessionStorage.getItem('cart') || "";
    this.cartItems = JSON.parse(jsonString);
    this.cartItems.forEach(element => {
       this.shopService.getProduct(element.id).toPromise().then( resp => {
          element.product = resp;
          element.product.mainPicture = element.product.pictures[0];
          this.totalPrice += element.product.price * element.amount;
      })
    });
  }

  calculateTotalPrice(){
    this.totalPrice = 0;
    this.cartItems.forEach( element => {
        this.totalPrice += (element.product?.price || 0) * element.amount;
    })
    this.delievery ? this.totalPrice += 220 : this.totalPrice += 0;
  }

  pickupChanged(event: any){
    this.delievery = event['target']['value'] === "2";
    this.calculateTotalPrice()
  }

  sendOrder(){
    console.log(this.formData);
    let cart: Cart = {fullName: this.formData.value['fullName'], 
                      address: this.formData.value['address'],
                      email: this.formData.value['email'],
                      delievery: this.delievery,
                      phoneNumber: this.formData.value['phoneNumber'],
                      items: this.cartItems,
                      finalPrice: this.totalPrice
                      }
    this.shopService.sendOrder(cart).toPromise().then( response => {
      this.orderNumber = response['id'];
      var elem = document.getElementById('overlay');
      elem ? elem.style.display = "block" : '';
    });

  }
  
  overlayOff() {
    var elem = document.getElementById('overlay');
    elem ? elem.style.display = "none" : '';  
    sessionStorage.clear();
    this.router.navigateByUrl('/shop')
  }

  removeItem(id: number){
    this.cartItems = this.cartItems.filter(element => element.id !== id);
    this.calculateTotalPrice();
  }
}
