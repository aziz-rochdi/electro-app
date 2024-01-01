import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{
  products$: Observable<any> = EMPTY;

  constructor(private _http: HttpClient){

  }

  ngOnInit(): void {
      this.products$ = this._http.get('http://localhost:8888/PRODUCT-SERVICE/products')
  }
}
