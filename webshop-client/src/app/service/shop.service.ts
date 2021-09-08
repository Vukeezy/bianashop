import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Cart, CartItem, FilterParams, Product, SearchParams, SortParams } from '../model/shop.model';

@Injectable({providedIn: 'root'})
export class ShopService {

  baseUrl = 'http://localhost:8080/api/';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {
  }

  getProducts = () => this.http.get<Product[]>(this.baseUrl + 'items');

  getProduct = (id: number) => this.http.get<Product>(this.baseUrl + 'items/getById?id=' + id);

  sendOrder = (cart: Cart) => this.http.post<any>(this.baseUrl + 'orders', cart);

  addItemToCart(item: CartItem){
    if(!sessionStorage.getItem('cart')){
      sessionStorage.setItem('cart', JSON.stringify([]));
      sessionStorage.setItem('cartCount', JSON.stringify(0));
    }
    let cart: CartItem[] = JSON.parse(sessionStorage.getItem('cart') || '');
    cart.push(item);
    sessionStorage.setItem('cart', JSON.stringify(cart));
    sessionStorage.setItem('cartCount', JSON.stringify(cart.length))
  }

  sortProducts = (sortParams: SortParams) => this.http.post<Product[]>(this.baseUrl + 'items/sort', sortParams);

  searchProducts = (input: SearchParams) => this.http.post<Product[]>(this.baseUrl + 'items/search', input);

  filterProducts = (filterParams: FilterParams) => this.http.post<Product[]>(this.baseUrl + 'items/filter', filterParams);

  //getCertificates = () => this.http.get<Certificate>(this.baseUrl + 'certificate');

  //acceptRequest = (createViewModel: CertificateCreation) => this.http.post<void>(this.baseUrl + 'certificate', createViewModel);
}
