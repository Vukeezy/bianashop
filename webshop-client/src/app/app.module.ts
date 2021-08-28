import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserNavComponent } from './navigation/user-nav/user-nav.component';
import { ShopService } from './service/shop.service';
import { ViewModule } from './view/view.module';

@NgModule({
  declarations: [
    AppComponent,
    UserNavComponent
  ],
  imports: [
    HttpClientModule,
    ViewModule,
    BrowserModule,
    AppRoutingModule,

  ],
  providers: [ShopService],
  bootstrap: [AppComponent]
})
export class AppModule { }
