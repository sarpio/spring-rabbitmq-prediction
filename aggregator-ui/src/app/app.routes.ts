import {Routes} from '@angular/router';
import {TemperatureComponent} from './components/temperature/temperature.component';
import {ExchangeComponent} from './components/exchange/exchange.component';
import {GraphDemoComponent} from './components/graph-demo/graph-demo.component';

export const routes: Routes = [
  {path: '', redirectTo: 'temperature', pathMatch: 'full'},
  {path: 'temperature', component: TemperatureComponent, pathMatch: 'full'},
  {path: 'exchange', component: ExchangeComponent, pathMatch: 'full'},
  {path: 'graph', component: GraphDemoComponent, pathMatch: 'full'},
];
