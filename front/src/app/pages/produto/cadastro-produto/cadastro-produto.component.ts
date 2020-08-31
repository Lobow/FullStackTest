import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/model/produto';
import { ProdutoService } from 'src/app/services/produto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.scss']
})
export class CadastroProdutoComponent implements OnInit {
  produto: Produto ={
    nome: '',
    data:null,
    detalhes: ''
  }

  constructor(private produtoService: ProdutoService, private router: Router) {}

  ngOnInit(): void {
  }


  cadastraProduto(): void {
    this.produtoService.cadastrar(this.produto).subscribe(() => {
      this.router.navigate(['/produto'])
    })

  }

  cancel(): void {
    this.router.navigate(['/produto'])
  }


}
