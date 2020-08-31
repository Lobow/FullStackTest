import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProdutoComponent } from './pages/produto/produto.component';
import { HomeComponent } from './pages/home/home.component';
import { CadastroProdutoComponent } from './pages/produto/cadastro-produto/cadastro-produto.component';
import { UpdateProdutoComponent } from './pages/produto/update-produto/update-produto.component';


const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "produto",
    component: ProdutoComponent
  },
  {
    path: "cadastrar-produto",
    component: CadastroProdutoComponent
  },
  {
    path: "produto/update/:id",
    component: UpdateProdutoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
 