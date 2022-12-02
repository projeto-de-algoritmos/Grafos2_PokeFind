import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Areas} from "./areas";

const API = 'apiArea';

@Injectable({
  providedIn: 'root'
})
export class AreaService {

  constructor(private http: HttpClient) { }

  listArea(): Observable<Areas> {
    return this.http.get<Areas>(`${API}/areas`);
  }

}
