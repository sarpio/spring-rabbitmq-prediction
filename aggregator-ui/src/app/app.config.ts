import {ApplicationConfig, provideZoneChangeDetection} from '@angular/core';
import {provideRouter} from '@angular/router';

import {routes} from './app.routes';
import {provideHttpClient} from '@angular/common/http';
import {provideEchartsCore} from 'ngx-echarts';
import echarts from 'echarts/types/src/echarts.js';
import {provideCharts, withDefaultRegisterables} from 'ng2-charts';
import {BarController, Colors, Legend} from 'chart.js';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({eventCoalescing: true}),
    provideRouter(routes),
    provideHttpClient(),
    provideCharts({ registerables: [BarController, Legend, Colors] }),
  ]
};
