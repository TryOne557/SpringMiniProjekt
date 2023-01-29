import {NgModule} from '@angular/core';
import {RouterModule, Routes, UrlSegment} from "@angular/router";
import {LoginComponent} from "./registration/login/login.component";
import {SignupComponent} from "./registration/signup/signup.component";


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},


  {
    matcher: (url) => {
      console.log(url)
      // You can have regex as per your requirement
      if (url.length === 1 && url[0].path.match(/^@\w+$/gm)) {
        return {
          consumed: url,
          posParams: {
            username: new UrlSegment(url[0].path.substring(1), {}) // <--- creating UrlSegment by getting rid of @ from url path
          }
        };
      }

      return null;
    },
    // redirectTo: 'profile/:username',
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {path: '**', redirectTo: 'home'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
