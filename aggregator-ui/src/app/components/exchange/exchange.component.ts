import {Component, OnInit} from '@angular/core';
import {ExchangeService} from '../../services/exchange.service';
import {Exchange} from '../../model/Exchange';
import {DatePipe} from '@angular/common';
import {NumberDiffPipe} from '../../pipe/number-diff.pipe';

@Component({
  selector: 'app-exchange',
  imports: [
    DatePipe,
    NumberDiffPipe
  ],
  templateUrl: './exchange.component.html',
  styleUrl: './exchange.component.scss'
})
export class ExchangeComponent implements OnInit {

  public exchanges: Exchange[] = [];

  constructor(private exchangeService: ExchangeService) {
  }

  ngOnInit(): void {
    this.exchangeService.getExchangeHistory().subscribe({
      next: (result: Exchange[]) => {
        this.exchanges = result;
      }
    })
  }
}
