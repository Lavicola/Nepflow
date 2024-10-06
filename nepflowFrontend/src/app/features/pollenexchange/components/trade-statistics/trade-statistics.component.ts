import {Component, Input, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {ArcElement, Chart, Legend, PieController, Title, Tooltip} from 'chart.js'
import {TradeStatusDto} from "../../models/trade-status-dto";
import {ReviewType} from "../../models/review-type";
import {TradesService} from "../../services/trades.service";

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
  tradeRatingsBehaviorSubject: BehaviorSubject<TradeStatusDto[]> = new BehaviorSubject<TradeStatusDto[]>([]);
  tradeRating: Observable<TradeStatusDto[]> = this.tradeRatingsBehaviorSubject.asObservable();
  ratingCounter = new Map<string, number>;
  public chart: any;
  private data: any;


  constructor(private tradeService: TradesService) {
    this.ratingCounter.set(ReviewType.PENDING, 0);
    this.ratingCounter.set(ReviewType.SUCCESS, 0);
    this.ratingCounter.set(ReviewType.FAILURE, 0);


  }


  ngOnInit(): void {

    this.createChart();
    this.tradeService.pollenexchangeUsernameTradesStatusGet({username: this.username}).subscribe({


      next: (trades: TradeStatusDto[]) => this.tradeRatingsBehaviorSubject.next(trades)
    });

    // Use the tradeRatingsBehaviorSubject to count different rating statuses
    this.tradeRating.subscribe({
      next: (ratings) => {
        ratings?.forEach(rating => {
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


  }

  createChart() {

    this.data = {
      labels: [ReviewType.PENDING.toLowerCase(),
        ReviewType.SUCCESS.toLowerCase(),
        ReviewType.FAILURE.toLowerCase(),],
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

    return [this.ratingCounter.get(ReviewType.PENDING),
      this.ratingCounter.get(ReviewType.SUCCESS),
      this.ratingCounter.get(ReviewType.FAILURE)]

  }

  updateChart() {
    this.chart.data.datasets[0].data = this.getNewData();
    this.chart.update();
  }


}
