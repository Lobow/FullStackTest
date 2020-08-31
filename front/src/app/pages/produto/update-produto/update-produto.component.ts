import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProdutoService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/model/produto';

@Component({
  selector: 'app-update-produto',
  templateUrl: './update-produto.component.html',
  styleUrls: ['./update-produto.component.scss']
})
export class UpdateProdutoComponent implements OnInit {

  produto: Produto;

  constructor(private produtoService: ProdutoService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = + this.route.snapshot.paramMap.get("id");
    this.produtoService.readById(id).subscribe((produto) => {
      this.produto = produto;
    });

}
updateProduto(): void {
  this.produtoService.update(this.produto).subscribe(() => {
    this.router.navigate(["/produto"]);
  });
}

cancel(): void {
  this.router.navigate(["/produto"]);
}

}
