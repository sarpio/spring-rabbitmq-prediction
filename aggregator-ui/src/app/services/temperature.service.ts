import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Temperature} from '../model/Temperature';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TemperatureService {

  readonly URL = environment.url;

  constructor(private http: HttpClient) { }


  getTemperatureHistory():Observable<Temperature[]> {
    return this.http.get<Temperature[]>(`${this.URL}/temperature/stats`);
  }
}
