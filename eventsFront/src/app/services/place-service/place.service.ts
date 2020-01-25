import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { AuthService } from '../auth-service/auth.service';

const authHttpOptions = (token) => {
  return {
    headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Authorization': 'Bearer ' + token
   })
  }
}

@Injectable({
  providedIn: 'root'
})
export class PlaceService {
  
  private url: string;
  private places;

  constructor(
    private http: HttpClient,
    private authService: AuthService,
    private router: Router
  ) { 
    this.url = 'http://localhost:8080/api';
  }

  public getPlaces() {
    return this.http.get(this.url + "/places", authHttpOptions(this.authService.getToken()))
    .pipe(map(
      res => {
        return res;
      }
    ))
  }
}
