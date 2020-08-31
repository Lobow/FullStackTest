import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Produto } from '../model/produto';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }


  cadastrar(produto: Produto): Observable<Produto>{
    return this.http.post<Produto>(`${environment.API}/produto`, produto)
  }

  read(): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${environment.API}/produto/`);
  }

  readById(id: number): Observable<any> {
    console.log(id)
    return this.http.get(`${environment.API}/produto/${id}`);
  }
  
  update(produto: Produto): Observable<Produto>{
    return this.http.put<Produto>(`${environment.API}/produto/update/${produto.id}`,produto);
  }

  delete(id: number): Observable<Produto>{
    return this.http.delete<Produto>(`${environment.API}produto/delete/${id}`);
  }

}

