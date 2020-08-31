import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/model/produto';
import { ProdutoService } from 'src/app/services/produto.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {
  produtos: Produto[];
  produto: Produto
  displayedColumns = ["id","nome","data","detalhes", "action"]

  constructor(private produtoService: ProdutoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void { this.produtoService.read().subscribe(produtos => {
    this.produtos = produtos
      })
  }

  delete(id: number): void{
  
    this.produtoService.delete(id).subscribe(()=>{
      this.router.navigate(['/produto'])
    })
  }

}
