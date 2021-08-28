import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ComponentsModule } from "../components/components.module";
import { HomePageComponent } from "./home-page/home-page.component";
import { ShopPageComponent } from "./shop-page/shop-page.component";
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CheckoutPageComponent } from './checkout-page/checkout-page.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

@NgModule({
    declarations: [
        HomePageComponent,
        ShopPageComponent,
        ProductDetailsComponent,
        CheckoutPageComponent
    ],
    imports: [
        ComponentsModule,
        CommonModule,
        FormsModule,
        ReactiveFormsModule
    ],
    providers: []
  })
  export class ViewModule { }
  