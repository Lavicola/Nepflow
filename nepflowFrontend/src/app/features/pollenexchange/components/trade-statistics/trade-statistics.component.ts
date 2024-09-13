import {Component, Input, OnInit} from '@angular/core';
import {PollenexchangeService} from "../../services/pollenexchange.service";
import {UserDto} from "../../../../core/models/user-dto";
import {BehaviorSubject, map, Observable} from "rxjs";
import {TradeStatus} from "../../models/trade-status";
import {TradeRatingsDto} from "../../models/trade-ratings-dto";
import {
  Chart, PieController, ArcElement, Title, Legend,Tooltip
} from 'chart.js'

Chart.register(PieController, ArcElement, Title, Legend,Tooltip);


@Component({
  selector: 'app-trade-statistics',
  standalone: true,
  imports: [],
  templateUrl: './trade-statistics.component.html',
  styleUrl: './trade-statistics.component.sass'
})
export class TradeStatisticsComponent implements OnInit {

  @Input() username!: string;
  tradeRatingsBehaviorSubject: BehaviorSubject<TradeRatingsDto> = new BehaviorSubject<TradeRatingsDto>({});
  tradeRating: Observable<TradeRatingsDto> = this.tradeRatingsBehaviorSubject.asObservable();
  ratingCounter = new Map<string, number>;
  public chart: any;
  private data: any;


  constructor(private tradeService: PollenexchangeService) {
    this.ratingCounter.set(TradeStatus.PENDING, 0);
    this.ratingCounter.set(TradeStatus.SUCCESS, 0);
    this.ratingCounter.set(TradeStatus.FAILURE, 0);


  }


  ngOnInit(): void {
    this.tradeService.pollenexchangeUsernameTradeStatusGet({username: this.username}).subscribe({
      next: (trades: TradeRatingsDto) => this.tradeRatingsBehaviorSubject.next(trades)
    });

    // Use the tradeRatingsBehaviorSubject to count different rating statuses
    this.tradeRating.subscribe({
      next: (ratings) => {
        ratings.ratings?.forEach(rating => {
          if (rating.status) {
            // @ts-ignore
            this.ratingCounter.set(rating.status, this.ratingCounter.get(rating.status) + 1)
          }
        })
        console.log(this.ratingCounter)
        this.updateChart();

      },
      error: (err) => console.log(err)
    })

    this.createChart();

  }

  createChart() {

    this.data = {
      labels: [TradeStatus.PENDING.toLowerCase(),
        TradeStatus.SUCCESS.toLowerCase(),
        TradeStatus.FAILURE.toLowerCase(),],
      datasets: [{
        label: 'Trading Status',

        data: this.getNewData(),
        backgroundColor: [
          'yellow',
          'green',
          'red',
        ],
      }]
    }

    this.chart = new Chart("PieChart", {
      type: 'pie',
      data: {
        labels: this.data.labels,
        datasets: this.data.datasets
      },
      options: {
        responsive: true,
        aspectRatio: 2.5,
        },


    });
  }

  getNewData() {

    return [this.ratingCounter.get(TradeStatus.PENDING),
      this.ratingCounter.get(TradeStatus.SUCCESS),
      this.ratingCounter.get(TradeStatus.FAILURE)]

  }

  updateChart() {
    this.chart.data.datasets[0].data = this.getNewData();
    this.chart.update();
  }


}
