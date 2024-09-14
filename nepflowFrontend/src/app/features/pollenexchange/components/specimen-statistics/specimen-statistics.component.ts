import {Component, Input, OnInit} from '@angular/core';
import {PollenexchangeService} from "../../services/pollenexchange.service";
import {BehaviorSubject, Observable} from "rxjs";
import {PollenOfferSpeciesStatisticsDto} from "../../models/pollen-offer-species-statistics-dto";
import {
  Chart, BarController, Title, Legend, CategoryScale, LinearScale, BarElement
} from 'chart.js'

Chart.register(BarController, Title, Legend, CategoryScale, LinearScale, BarElement);

@Component({
  selector: 'app-specimen-statistics',
  standalone: true,
  imports: [],
  templateUrl: './specimen-statistics.component.html',
  styleUrl: './specimen-statistics.component.sass'
})
export class SpecimenStatisticsComponent implements OnInit {

  @Input() username!: string;
  specimenStatisticBehaviourSubject: BehaviorSubject<PollenOfferSpeciesStatisticsDto[]> = new BehaviorSubject<PollenOfferSpeciesStatisticsDto[]>([]);
  specimenStatistics$: Observable<PollenOfferSpeciesStatisticsDto[]> = this.specimenStatisticBehaviourSubject.asObservable();
  public chart: any;
  private labels: string[] = []
  private data: number[] = []

  constructor(private tradeService: PollenexchangeService) {
  }

  ngOnInit(): void {
    this.createChart();


    this.tradeService.pollenexchangeUsernamePollenoffersStatisticsGet({username: this.username}).subscribe({
      next: (stats) => this.specimenStatisticBehaviourSubject.next(stats),
      error: (err) => console.log(err)

    });


    this.specimenStatistics$.subscribe({
      next: (stats) => {
        stats.forEach(stat => {
          this.labels.push(`${stat.nepenthesName} (${stat.cloneId})`)

          this.data.push(<number>stat.floweringCount)
        });
        this.chart.update();
      },
      error: (err) => {
        console.error('Error fetching specimen statistics', err);
      },
      complete: () => {
        console.log('Completed fetching specimen statistics');

      }
    });



  }


  createChart() {

    let data = {
      labels: this.labels,
      display: false,

      datasets: [{
        label: 'Times Flowered',
        data: this.data,
        backgroundColor: ["#25CCF7", "#FD7272", "#54a0ff", "#00d2d3",
          "#1abc9c", "#2ecc71", "#3498db", "#9b59b6", "#34495e",
          "#16a085", "#27ae60", "#2980b9", "#8e44ad", "#2c3e50",
          "#f1c40f", "#e67e22", "#e74c3c", "#ecf0f1", "#95a5a6",
          "#f39c12", "#d35400", "#c0392b", "#bdc3c7", "#7f8c8d",
          "#55efc4", "#81ecec", "#74b9ff", "#a29bfe", "#dfe6e9",
          "#00b894", "#00cec9", "#0984e3", "#6c5ce7", "#ffeaa7",
          "#fab1a0", "#ff7675", "#fd79a8", "#fdcb6e", "#e17055",
          "#d63031", "#feca57", "#5f27cd", "#54a0ff", "#01a3a4"
        ],

      }]
    }

    this.chart = new Chart("BarChart", {
        type: 'bar',


        data: {
          labels: data.labels,
          datasets: data.datasets
        },

        options: {

          plugins: {
            legend: {
              display:false
            }
          },

          indexAxis: 'y',
          responsive: true,
          scales: {
            y: {
              beginAtZero: true,
              display: true
            },
            x: {
              display: true,
              ticks: {
                callback: function (value, index, ticks) {
                  // @ts-ignore
                  return index;
                }
              },


            }

          },
        },


      }
    );
  }


}
