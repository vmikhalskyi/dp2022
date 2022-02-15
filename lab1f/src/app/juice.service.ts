import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Juice } from './interfaces/juice';

@Injectable({
  providedIn: 'root'
})
export class JuiceService {
  url: string = "/lab1/Servlet1";

  constructor(private http: HttpClient) { }

  getJuices():Observable<Juice[]> {
    return this.http.get<Juice[]>(this.url);
  }

  setJuice(params: any):Observable<Object> {
    return this.http.put(this.url, {}, { params: params });
  }
}
