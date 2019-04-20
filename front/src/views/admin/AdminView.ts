import Vue from 'vue'
import Component from 'vue-class-component'

interface Item {
  icon: string;
  title: string;
  routerName: string;
}

@Component({ name: 'admin-view' })
export default class AdminView extends Vue {
  public drawer: boolean = true;
  public sideBarItems: Item[] = [
    { icon: 'home', title: 'Principal', routerName: 'home' },
    { icon: 'dashboard', title: 'Dashboard', routerName: 'dashboard' },
    { icon: 'account_balance_wallet', title: 'Cuentas', routerName: 'accounts' },
    { icon: 'person', title: 'Usuarios', routerName: 'users' },
    { icon: 'people', title: 'Beneficiarios', routerName: 'beneficiaries' },
    { icon: 'timer', title: 'Medidores', routerName: 'measurers' },
    { icon: 'format_list_bulleted', title: 'Servicios', routerName: 'services' },
    { icon: 'description', title: 'Reportes', routerName: 'reports' }
  ];
  public optionItems: Item[] = [
    { icon: 'settings', title: 'Configuraciones', routerName: 'adminsettings' },
    { icon: 'info', title: 'Ayuda', routerName: 'adminhelp' },
    { icon: 'logout', title: 'Salir', routerName: 'login' }
  ];

  public changeView (routerName: string): void {
    if (routerName === 'measurers') {
      this.$router.push({ name: routerName, params: { beneficiaryId: '0' } })
    }
    this.$router.push({ name: routerName })
  }
}
