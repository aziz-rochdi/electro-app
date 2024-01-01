import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients$: Observable<any> = EMPTY;

  constructor(private _http: HttpClient){

  }

  ngOnInit(): void {
      this.clients$ = this._http.get('http://localhost:8888/CLIENT-SERVICE/clients')
  }
}
