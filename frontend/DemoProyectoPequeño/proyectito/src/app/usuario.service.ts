import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Usuario } from '../app/models/usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

   apiUrl = 'http://localhost:8080/api';
   usuario: Usuario [] = [];

   httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  registro(usuario: Usuario){
    const url = '/crear';
    return this.http.post<Usuario>(this.apiUrl+url, usuario, this.httpOptions);
  }

  mostrarUsuarios(): Observable<Usuario[]>{
    const url = '/usuario/tabla/'
    return this.http.get<Usuario[]>(this.apiUrl+url);
  }

  loginUsuario(usuario: Usuario): Observable<Usuario> {
    const url = '/loginUsuario/'
    return this.http.post<Usuario>(this.apiUrl+url, usuario, this.httpOptions);
  }

  borrarUser(rut: string): Observable<{}> {
    const url = '/usuario/borrar/'
    return this.http.delete(this.apiUrl+url+rut, this.httpOptions);
  }
  
  editarCuentaUsuario(usuario: Usuario) {
    const url = '/usuario/editar/'
    return this.http.put<Usuario>(this.apiUrl+url, usuario, this.httpOptions);
  }
}
