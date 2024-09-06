import {Component, Renderer2} from '@angular/core';
import {MatSlideToggle} from "@angular/material/slide-toggle";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-dark-light-theme',
  standalone: true,
  imports: [
    MatSlideToggle,
    MatButton
  ],
  templateUrl: './dark-light-theme.component.html',
  styleUrl: './dark-light-theme.component.sass'
})
export class DarkLightThemeComponent {
  constructor(private renderer: Renderer2) {
  }


  changeTheme() {
    const body = document.body;
    if (body.classList.contains('dark-mode')) {
      // Remove the "dark-mode" class and change it to "light-mode"
      this.renderer.removeClass(body, 'dark-mode');
      this.renderer.addClass(body, 'light-mode');
    } else {
      // If not in dark mode, change to dark mode
      this.renderer.removeClass(body, 'light-mode');
      this.renderer.addClass(body, 'dark-mode');
    }


  }

}
