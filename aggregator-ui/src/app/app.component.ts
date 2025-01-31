import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {TemperatureService} from './services/temperature.service';
import {Temperature} from './model/Temperature';
import {ExchangeService} from './services/exchange.service';
import {Exchange} from './model/Exchange';
import {HeaderComponent} from './shared/header/header.component';
import {TemperatureComponent} from './components/temperature/temperature.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'aggregator-ui';

}
