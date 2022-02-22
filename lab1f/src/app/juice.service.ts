import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { IJuice } from './interfaces/juice';

@Injectable({
  providedIn: 'root'
})
export class JuiceService {
  url: string = "/lab1/Servlet1";
  list = new BehaviorSubject<IJuice[]>([]);

  constructor(private http: HttpClient) { }

  getJuices():Observable<IJuice[]> {
    return this.http.get<IJuice[]>(this.url);
  }

  postJuice(juice: IJuice): Observable<IJuice[]> {
    return this.http.post<IJuice[]>(this.url, juice);
  }

  putJuice(juice: IJuice): Observable<IJuice[]> {
    return this.http.put<IJuice[]>(this.url + "/" + juice.id, juice);
  }

  deleteJuice(juice: IJuice): Observable<IJuice[]> {
    return this.http.delete<IJuice[]>(this.url + "/" + juice.id);
  }

  setList(list: IJuice[]) {
    this.list.next(list);
  }
}
