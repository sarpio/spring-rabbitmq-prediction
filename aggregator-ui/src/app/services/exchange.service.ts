import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Temperature} from '../model/Temperature';
import {Exchange} from '../model/Exchange';

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {

  readonly URL = environment.url;

  constructor(private http: HttpClient) { }


  getExchangeHistory():Observable<Exchange[]> {
    return this.http.get<Exchange[]>(`${this.URL}/exchange/stats`);
  }
}
