import {Component, OnInit} from '@angular/core';
import {TemperatureService} from '../../services/temperature.service';
import {Temperature} from '../../model/Temperature';
import {CelsiusPipe} from '../../pipe/celsius.pipe';
import {NumberDiffPipe} from '../../pipe/number-diff.pipe';

@Component({
  selector: 'app-temperature',
  imports: [
    CelsiusPipe,
    NumberDiffPipe,

  ],
  providers: [],
  templateUrl: './temperature.component.html',
  styleUrl: './temperature.component.scss'
})
export class TemperatureComponent implements OnInit {

  public temperature: Temperature[] = [];

  constructor(private temperatureService: TemperatureService) {
  }

  ngOnInit(): void {
    this.temperatureService.getTemperatureHistory().subscribe({
      next: (result: Temperature[]) => {
        this.temperature = result;
        result.map((temperature: Temperature) => {
        })
      }
    })
  }
}
