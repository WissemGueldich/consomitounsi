import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8081/api/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }


  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }

  getUsers():Observable<any> {
    return this.http.get('http://localhost:8081/user/getusers', { responseType: 'text' });
  }

  getUser(id):Observable<any> {
    return this.http.get(API_URL + 'http://localhost:8081/user/getuser/'+id, { responseType: 'text' });
  }
  
  updateUser(user):Observable<any> {
    return this.http.put(API_URL + 'http://localhost:8081/user/updateuser/', { responseType: 'text' });
  }

  deleteUser(id):Observable<any> {
    return this.http.delete(API_URL + 'http://localhost:8081/user/getuser/'+id, { responseType: 'text' });
  }
}