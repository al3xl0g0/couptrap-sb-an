import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class BikeService {

  constructor(private http:HttpClient) { }

  getBikes() {
    let token = localStorage.getItem('access_token');
    return this.http.get('/server/api/v1/comp',
      {headers: new HttpHeaders().set('Authorization', 'Bearer ' + token)}
    );
  }

  getBike(id: number) {
    let token = localStorage.getItem('access_token');
    return this.http.get('/server/api/v1/comp/' + id,
      {headers: new HttpHeaders().set('Authorization', 'Bearer ' + token)}
    );
  }

  createBikeRegistration(bike) {
    let body = JSON.stringify(bike);
    return this.http.post('/server/api/v1/comp', body, httpOptions);
  }

}
