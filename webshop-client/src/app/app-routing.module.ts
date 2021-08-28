import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckoutPageComponent } from './view/checkout-page/checkout-page.component';
import { HomePageComponent } from './view/home-page/home-page.component';
import { ProductDetailsComponent } from './view/product-details/product-details.component';
import { ShopPageComponent } from './view/shop-page/shop-page.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'shop', component: ShopPageComponent},
  { path: 'product-details', component: ProductDetailsComponent},
  { path: 'checkout', component: CheckoutPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
