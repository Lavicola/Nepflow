import {Component, OnInit, Renderer2} from '@angular/core';
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
export class DarkLightThemeComponent implements OnInit {

  readonly THEME_KEY = "theme"
  readonly DARK_THEME = "dark-mode"
  readonly LIGHT_THEME = "light-mode"
  readonly THEMES = [this.LIGHT_THEME, this.DARK_THEME]
  THEME_INDEX_AS_BOOLEAN: boolean = false;

  constructor(private renderer: Renderer2) {

  }


  toggleTheme() {
    this.setTheme(
      this.THEMES[+this.THEME_INDEX_AS_BOOLEAN],
      this.THEMES[+!this.THEME_INDEX_AS_BOOLEAN]
    )
    this.THEME_INDEX_AS_BOOLEAN = !this.THEME_INDEX_AS_BOOLEAN
    localStorage.setItem(this.THEME_KEY, JSON.stringify(this.THEME_INDEX_AS_BOOLEAN));
  }


  setTheme(oldTheme: string, newTheme: string) {
    const body = document.body;
    if (body.classList.contains(oldTheme)) {
      this.renderer.removeClass(body, oldTheme);
      this.renderer.addClass(body, newTheme);
    } else if (!body.classList.contains(newTheme)) {
      // old theme does not exist and new Theme does not exist
      this.renderer.addClass(body, newTheme);
    } else {
      // old theme does not exist and new Theme already exists
      return
    }
  }


  ngOnInit(): void {
    if (!localStorage[this.THEME_KEY]) {
      localStorage.setItem(this.THEME_KEY, JSON.stringify(+this.THEME_INDEX_AS_BOOLEAN));
    } else {
      // @ts-ignore
      this.THEME_INDEX_AS_BOOLEAN = this.getLocalStorageValueAsBoolean(this.THEME_KEY);
      this.setTheme(
        this.THEMES[+this.THEME_INDEX_AS_BOOLEAN],
        this.THEMES[+this.THEME_INDEX_AS_BOOLEAN])
    }
  }

  getLocalStorageValueAsBoolean(key: string) {
    return localStorage.getItem(key) === 'true'
  }

}
