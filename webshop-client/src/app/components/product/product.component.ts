import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/model/shop.model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product!: Product;
  @Output() detailsClicked = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {

  }

  onDetailsClicked(){
    this.detailsClicked.emit(this.product.id)
  }

}
