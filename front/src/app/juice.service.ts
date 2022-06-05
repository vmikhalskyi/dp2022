import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { IJuice } from './interfaces/juice';
import { ResponseUser } from './interfaces/response';

@Injectable({
  providedIn: 'root'
})
export class JuiceService {
  url: string = "http://localhost:1155/juices";
  juiceList = new BehaviorSubject<IJuice[]>([]);

  constructor(private http: HttpClient) { }

  getJuices():Observable<ResponseUser> {
    return this.http.get<ResponseUser>(this.url);
  }

  postJuice(juice: IJuice): Observable<IJuice[]> {
    return this.http.post<IJuice[]>(this.url, juice);
  }

  putJuice(juice: IJuice): Observable<IJuice[]> {
    const body = {
      title: juice.title,
      descr: juice.descr,
      img: juice.img
    };
    return this.http.put<IJuice[]>(juice.link || this.url, body);
  }

  deleteJuice(juice: IJuice): Observable<IJuice[]> {
    return this.http.delete<IJuice[]>(juice.link || this.url);
  }

  setJuiceList(list: IJuice[]) {
    this.juiceList.next(list);
  }
}
