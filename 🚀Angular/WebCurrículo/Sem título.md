import { Component, HostListener, signal, OnInit, ElementRef, ViewChildren, QueryList, afterNextRender, inject, PLATFORM_ID } from '@angular/core';

import { CommonModule, isPlatformBrowser } from '@angular/common';

import { HttpClient, HttpClientModule } from '@angular/common/http';

  

// Interfaces para tipagem

interface Theme {

  name: string;

  primary: string;

  secondary: string;

  accent: string;

}

  

interface GithubProfile {

  login: string;

  avatar_url: string;

  public_repos: number;

  followers: number;

  html_url: string;

  bio: string;

}

  

interface GithubRepo {

  name: string;

  description: string;

  html_url: string;

  language: string;

  stargazers_count: number;

  updated_at: string;

}

  

@Component({

  selector: 'app-root',

  standalone: true,

  imports: [CommonModule, HttpClientModule],

  template: `

    <div [class]="darkMode() ? 'dark' : ''" class="transition-colors duration-500">

      <!-- Wrapper Principal com Variáveis CSS de Tema -->

      <div class="min-h-screen bg-slate-50 text-slate-800 dark:bg-slate-950 dark:text-slate-200 font-sans transition-colors duration-500 overflow-x-hidden"

           [style.--primary]="currentTheme().primary"

           [style.--secondary]="currentTheme().secondary"

           [style.--accent]="currentTheme().accent">

        <!-- Navigation -->

        <nav [class]="navClass()" class="fixed w-full top-0 z-50 transition-all duration-300 border-b border-transparent dark:border-white/5">

          <div class="container mx-auto px-6 py-4 flex justify-between items-center">

            <!-- Logo -->

            <a (click)="scrollTo('home')" class="cursor-pointer text-2xl font-bold tracking-tighter flex items-center gap-2">

              <span class="text-primary-gradient">DAVIDSON</span>

              <span class="text-slate-400 text-sm font-mono">&lt;/DEV&gt;</span>

            </a>

            <!-- Desktop Menu -->

            <div class="hidden md:flex items-center space-x-6 text-sm font-medium text-slate-600 dark:text-slate-400">

              <a (click)="scrollTo('home')" class="hover:text-[var(--primary)] cursor-pointer transition-colors">Início</a>

              <a (click)="scrollTo('about')" class="hover:text-[var(--primary)] cursor-pointer transition-colors">Sobre</a>

              <a (click)="scrollTo('experience')" class="hover:text-[var(--primary)] cursor-pointer transition-colors">Jornada</a>

              <a (click)="scrollTo('github')" class="hover:text-[var(--primary)] cursor-pointer transition-colors">GitHub</a>

              <!-- Seletor de Temas -->

              <div class="flex items-center gap-2 px-3 border-l border-slate-300 dark:border-slate-700">

                @for(theme of themes; track theme.name) {

                  <button (click)="setTheme(theme)"

                          [class.scale-125]="currentTheme().name === theme.name"

                          [style.background-color]="theme.primary"

                          class="w-4 h-4 rounded-full transition-transform hover:scale-110"

                          [title]="theme.name">

                  </button>

                }

              </div>

  

              <!-- Botão Dark Mode -->

              <button (click)="toggleDarkMode()" class="p-2 rounded-full hover:bg-slate-200 dark:hover:bg-slate-800 transition-colors text-lg">

                <i class="fa-solid" [class]="darkMode() ? 'fa-sun text-yellow-400' : 'fa-moon text-slate-600'"></i>

              </button>

  

              <a (click)="scrollTo('contact')" class="px-5 py-2 rounded-full bg-[var(--primary)] hover:brightness-110 text-white transition-all cursor-pointer shadow-lg shadow-[var(--primary)]/30">

                Contato

              </a>

            </div>

  

            <!-- Mobile Toggle -->

            <div class="flex items-center gap-4 md:hidden">

               <button (click)="toggleDarkMode()" class="text-xl text-slate-600 dark:text-slate-300">

                <i class="fa-solid" [class]="darkMode() ? 'fa-sun' : 'fa-moon'"></i>

              </button>

              <button (click)="toggleMenu()" class="text-slate-800 dark:text-slate-300 focus:outline-none">

                <i class="fa-solid fa-bars text-2xl"></i>

              </button>

            </div>

          </div>

  

          <!-- Menu Mobile -->

          @if (isMenuOpen()) {

            <div class="md:hidden bg-white/95 dark:bg-slate-900/95 backdrop-blur-xl border-b dark:border-white/10 absolute w-full left-0 top-full shadow-2xl animate-slide-down">

              <div class="flex flex-col p-6 space-y-4 text-center font-medium">

                <a (click)="scrollTo('home'); toggleMenu()" class="dark:text-slate-300 py-2">Início</a>

                <a (click)="scrollTo('experience'); toggleMenu()" class="dark:text-slate-300 py-2">Experiência</a>

                <a (click)="scrollTo('github'); toggleMenu()" class="dark:text-slate-300 py-2">GitHub Stats</a>

                <!-- Seletor de Temas Mobile -->

                <div class="flex justify-center gap-4 py-2">

                  @for(theme of themes; track theme.name) {

                    <button (click)="setTheme(theme)"

                            [style.background-color]="theme.primary"

                            class="w-6 h-6 rounded-full border-2 border-white dark:border-slate-800 shadow-sm">

                    </button>

                  }

                </div>

                <a (click)="scrollTo('contact'); toggleMenu()" class="text-white font-bold bg-[var(--primary)] py-3 rounded-lg">Fale Comigo</a>

              </div>

            </div>

          }

        </nav>

  

        <!-- Hero Section -->

        <section id="home" class="relative pt-32 pb-20 md:pt-48 md:pb-32 overflow-hidden min-h-screen flex items-center">

          <!-- Background Blobs Dinâmicos -->

          <div class="absolute top-0 right-0 -mr-20 -mt-20 w-[500px] h-[500px] bg-[var(--primary)] rounded-full blur-[120px] opacity-20 pointer-events-none animate-pulse-slow"></div>

          <div class="absolute bottom-0 left-0 -ml-20 -mb-20 w-[400px] h-[400px] bg-[var(--secondary)] rounded-full blur-[100px] opacity-20 pointer-events-none animate-pulse-slow delay-1000"></div>

  

          <div class="container mx-auto px-6 flex flex-col-reverse md:flex-row items-center gap-12">

            <!-- Conteúdo Texto -->

            <div class="w-full md:w-1/2 space-y-6 z-10" #animateItem>

              <div class="inline-flex items-center gap-2 px-3 py-1 rounded-full bg-[var(--primary)]/10 border border-[var(--primary)]/20 text-[var(--primary)] text-sm font-bold tracking-wide">

                <span class="w-2 h-2 rounded-full bg-[var(--primary)] animate-ping"></span>

                Open to Work

              </div>

              <h1 class="text-5xl md:text-7xl font-extrabold leading-tight dark:text-white text-slate-900">

                Backend <br>

                <span class="text-transparent bg-clip-text bg-gradient-to-r from-[var(--primary)] to-[var(--secondary)]">Java & Cloud</span>

              </h1>

              <p class="text-lg text-slate-600 dark:text-slate-400 max-w-lg leading-relaxed">

                Olá, sou <strong>Davidson Linhares</strong>. Transformo requisitos complexos em arquiteturas escaláveis usando

                Spring Boot, AWS e DevOps.

              </p>

              <div class="flex flex-wrap gap-4 pt-4">

                <button (click)="scrollTo('experience')" class="px-8 py-4 rounded-full bg-[var(--primary)] text-white font-bold hover:brightness-110 transition-all shadow-lg shadow-[var(--primary)]/25 hover:-translate-y-1">

                  Ver Projetos

                </button>

                <a href="https://github.com/DavJaveiro" target="_blank" class="px-6 py-4 rounded-full border border-slate-300 dark:border-slate-700 hover:border-[var(--primary)] hover:text-[var(--primary)] transition-all flex items-center gap-2 cursor-pointer text-slate-600 dark:text-slate-300">

                  <i class="fa-brands fa-github text-xl"></i>

                  <span class="font-medium">GitHub</span>

                </a>

              </div>

            </div>

  

            <!-- Imagem (Efeito Tilt 3D) -->

            <div class="w-full md:w-1/2 flex justify-center md:justify-end relative" #animateItem>

              <div class="relative z-10 w-72 h-72 md:w-96 md:h-96 rounded-[2rem] overflow-hidden border-4 border-white dark:border-slate-800 shadow-2xl shadow-[var(--primary)]/20 rotate-3 hover:rotate-0 transition-all duration-700 group cursor-none">

                <div class="absolute inset-0 bg-gradient-to-tr from-[var(--primary)]/20 to-transparent opacity-0 group-hover:opacity-100 transition-opacity z-20"></div>

                <img [src]="portfolioData.profileImage" alt="Davidson" class="w-full h-full object-cover scale-105 group-hover:scale-110 transition-transform duration-700">

              </div>

              <!-- Formas Abstratas -->

              <div class="absolute top-10 right-10 w-full h-full border-2 border-[var(--primary)] rounded-[2rem] -z-10 rotate-6 opacity-50"></div>

              <div class="absolute -bottom-5 -left-5 w-24 h-24 bg-dots opacity-20 dark:invert"></div>

            </div>

          </div>

        </section>

  

        <!-- Seção Skills & Stats -->

        <section class="py-20 bg-white dark:bg-slate-900/50 border-y border-slate-200 dark:border-white/5">

          <div class="container mx-auto px-6">

            <div class="grid grid-cols-1 md:grid-cols-2 gap-16 items-center">

              <div #animateItem>

                <h2 class="text-3xl font-bold mb-6 dark:text-white">Tech Stack & Habilidades</h2>

                <p class="text-slate-600 dark:text-slate-400 mb-8">

                  Foco em tecnologias de alto desempenho e infraestrutura moderna. Minha stack principal envolve o ecossistema Java Enterprise e Cloud.

                </p>

                <div class="flex flex-wrap gap-3">

                  @for (skill of portfolioData.skills; track skill) {

                    <span class="px-4 py-2 rounded-lg bg-slate-100 dark:bg-slate-800 text-slate-700 dark:text-slate-300 text-sm font-semibold border border-slate-200 dark:border-slate-700 hover:border-[var(--primary)] hover:text-[var(--primary)] transition-colors cursor-default">

                      {{skill}}

                    </span>

                  }

                </div>

              </div>

              <!-- Visualização de Barras de Progresso -->

              <div class="space-y-6" #animateItem>

                @for(stat of skillStats; track stat.name) {

                  <div>

                    <div class="flex justify-between mb-2">

                      <span class="font-bold dark:text-white">{{stat.name}}</span>

                      <span class="text-[var(--primary)] font-mono">{{stat.level}}%</span>

                    </div>

                    <div class="h-3 w-full bg-slate-200 dark:bg-slate-800 rounded-full overflow-hidden">

                      <div class="h-full bg-gradient-to-r from-[var(--primary)] to-[var(--secondary)] rounded-full transition-all duration-1000 ease-out"

                           [style.width]="stat.inView ? stat.level + '%' : '0%'"></div>

                    </div>

                  </div>

                }

              </div>

            </div>

          </div>

        </section>

  

        <!-- Timeline Interativa -->

        <section id="experience" class="py-24 relative bg-slate-50 dark:bg-slate-950">

          <div class="container mx-auto px-6 max-w-5xl">

            <div class="text-center mb-16" #animateItem>

              <h2 class="text-4xl font-bold dark:text-white mb-4">Minha Jornada</h2>

              <p class="text-slate-600 dark:text-slate-400">Clique nos cards para ver os detalhes de cada experiência.</p>

            </div>

  

            <div class="relative">

              <!-- Linha Central -->

              <div class="absolute left-4 md:left-1/2 top-0 bottom-0 w-0.5 bg-slate-300 dark:bg-slate-800 md:-translate-x-1/2"></div>

  

              @for (job of portfolioData.experience; track job.company; let i = $index) {

                <div class="relative flex flex-col md:flex-row gap-8 mb-12 group cursor-pointer"

                     (click)="toggleJob(i)"

                     #animateItem>

                  <!-- Marcador Central -->

                  <div class="absolute left-4 md:left-1/2 w-4 h-4 rounded-full border-4 border-white dark:border-slate-900 bg-[var(--primary)] md:-translate-x-2 z-10 mt-1.5 shadow-[0_0_0_4px_rgba(var(--primary-rgb),0.2)] transition-transform group-hover:scale-125"></div>

  

                  <!-- Lado da Data -->

                  <div class="w-full md:w-1/2 pl-12 md:pl-0 md:pr-12 md:text-right"

                       [class.md:order-1]="i % 2 === 0"

                       [class.md:order-3]="i % 2 !== 0"

                       [class.md:text-left]="i % 2 !== 0"

                       [class.md:pl-12]="i % 2 !== 0">

                    <span class="inline-block font-mono text-sm text-[var(--primary)] bg-[var(--primary)]/10 px-3 py-1 rounded mb-2">

                      {{job.period}}

                    </span>

                    <h3 class="text-xl font-bold dark:text-white">{{job.role}}</h3>

                    <div class="text-slate-500 font-medium">{{job.company}}</div>

                  </div>

  

                  <!-- Card de Detalhes (Expansível) -->

                  <div class="w-full md:w-1/2 pl-12 md:pl-0 md:order-2 transition-all duration-300"

                       [class.md:pl-12]="i % 2 === 0"

                       [class.md:pr-12]="i % 2 !== 0">

                    <div class="bg-white dark:bg-slate-900 p-6 rounded-2xl border border-slate-200 dark:border-slate-800 shadow-sm hover:shadow-lg hover:border-[var(--primary)]/50 transition-all relative overflow-hidden">

                      <!-- Conteúdo Expandido -->

                      <div [class.max-h-0]="activeJobIndex() !== i"

                           [class.max-h-[500px]]="activeJobIndex() === i"

                           [class.opacity-50]="activeJobIndex() !== i"

                           [class.opacity-100]="activeJobIndex() === i"

                           class="transition-all duration-500 ease-in-out overflow-hidden">

                        <p class="text-slate-600 dark:text-slate-300 text-sm leading-relaxed whitespace-pre-line mb-4">

                          {{job.description}}

                        </p>

                        <div class="flex flex-wrap gap-2 pt-2 border-t border-slate-100 dark:border-slate-800">

                          @for(tech of job.tech; track tech) {

                            <span class="text-xs font-medium text-slate-500 bg-slate-100 dark:bg-slate-950 px-2 py-1 rounded border border-slate-200 dark:border-slate-800">

                              {{tech}}

                            </span>

                          }

                        </div>

                      </div>

                      <!-- Dica quando fechado -->

                      @if(activeJobIndex() !== i) {

                        <div class="text-sm text-slate-400 italic flex items-center gap-2">

                          <i class="fa-solid fa-chevron-down"></i> Clique para expandir

                        </div>

                      }

                      <!-- Selo Destaque -->

                      @if(job.highlight) {

                         <div class="absolute top-0 right-0 bg-gradient-to-bl from-[var(--primary)] to-transparent w-16 h-16 flex justify-end pr-2 pt-2 text-white">

                           <i class="fa-solid fa-star text-xs"></i>

                         </div>

                      }

                    </div>

                  </div>

                </div>

              }

            </div>

          </div>

        </section>

  

        <!-- Integração API GitHub -->

        <section id="github" class="py-24 bg-[var(--primary)]/5 dark:bg-slate-900 border-t border-slate-200 dark:border-white/5">

          <div class="container mx-auto px-6">

            <div class="flex flex-col md:flex-row items-center justify-between mb-12">

              <div #animateItem>

                <h2 class="text-3xl font-bold dark:text-white flex items-center gap-3">

                  <i class="fa-brands fa-github text-4xl"></i>

                  GitHub Activity

                </h2>

                <p class="text-slate-600 dark:text-slate-400 mt-2">Dados consumidos em tempo real da API do GitHub.</p>

              </div>

              @if(githubProfile(); as profile) {

                <div class="flex gap-6 mt-6 md:mt-0" #animateItem>

                  <div class="text-center">

                    <div class="text-3xl font-bold dark:text-white">{{profile.public_repos}}</div>

                    <div class="text-xs uppercase tracking-wider text-slate-500">Repositórios</div>

                  </div>

                  <div class="text-center">

                    <div class="text-3xl font-bold dark:text-white">{{profile.followers}}</div>

                    <div class="text-xs uppercase tracking-wider text-slate-500">Seguidores</div>

                  </div>

                </div>

              } @else {

                <!-- Skeleton Loading -->

                <div class="animate-pulse flex gap-6">

                  <div class="h-12 w-20 bg-slate-300 dark:bg-slate-800 rounded"></div>

                  <div class="h-12 w-20 bg-slate-300 dark:bg-slate-800 rounded"></div>

                </div>

              }

            </div>

  

            <!-- Grid de Repositórios -->

            <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">

              @if(loadingGithub()) {

                 @for(i of [1,2,3]; track i) {

                   <div class="h-40 bg-slate-200 dark:bg-slate-800 rounded-2xl animate-pulse"></div>

                 }

              } @else {

                 @for(repo of githubRepos(); track repo.name) {

                   <a [href]="repo.html_url" target="_blank"

                      class="group p-6 bg-white dark:bg-slate-950 rounded-2xl border border-slate-200 dark:border-slate-800 hover:border-[var(--primary)] transition-all hover:-translate-y-2 shadow-sm hover:shadow-xl block h-full"

                      #animateItem>

                     <div class="flex justify-between items-start mb-4">

                       <div class="p-2 rounded-lg bg-slate-100 dark:bg-slate-900 text-[var(--primary)]">

                         <i class="fa-solid fa-book-bookmark"></i>

                       </div>

                       <div class="flex items-center gap-1 text-sm text-slate-500">

                         <i class="fa-regular fa-star text-yellow-500"></i> {{repo.stargazers_count}}

                       </div>

                     </div>

                     <h3 class="font-bold text-lg dark:text-white mb-2 group-hover:text-[var(--primary)] transition-colors">{{repo.name}}</h3>

                     <p class="text-sm text-slate-600 dark:text-slate-400 line-clamp-2 mb-4 min-h-[40px]">

                       {{repo.description || 'Sem descrição.'}}

                     </p>

                     <div class="flex items-center justify-between pt-4 border-t border-slate-100 dark:border-slate-900 mt-auto">

                        <span class="text-xs font-mono text-[var(--secondary)]">{{repo.language || 'Code'}}</span>

                        <span class="text-xs text-slate-400">Atualizado: {{repo.updated_at | date:'shortDate'}}</span>

                     </div>

                   </a>

                 }

              }

            </div>

            <div class="text-center mt-12">

               <a href="https://github.com/DavJaveiro?tab=repositories" target="_blank" class="inline-flex items-center gap-2 text-[var(--primary)] font-bold hover:underline cursor-pointer">

                 Ver todos os repositórios <i class="fa-solid fa-arrow-right"></i>

               </a>

            </div>

          </div>

        </section>

  

        <!-- Footer -->

        <footer class="py-10 bg-slate-100 dark:bg-black text-center text-slate-500 text-sm border-t border-slate-200 dark:border-slate-900">

          <div class="container mx-auto px-6">

            <div class="flex justify-center gap-6 mb-6">

              <a href="https://www.linkedin.com/in/davidson-linhares" target="_blank" class="w-10 h-10 rounded-full bg-white dark:bg-slate-900 flex items-center justify-center hover:text-[var(--primary)] shadow-sm transition-all hover:scale-110 cursor-pointer"><i class="fa-brands fa-linkedin-in"></i></a>

              <a href="https://github.com/DavJaveiro" target="_blank" class="w-10 h-10 rounded-full bg-white dark:bg-slate-900 flex items-center justify-center hover:text-[var(--primary)] shadow-sm transition-all hover:scale-110 cursor-pointer"><i class="fa-brands fa-github"></i></a>

              <a href="mailto:Davidson.linhares@outlook.com" class="w-10 h-10 rounded-full bg-white dark:bg-slate-900 flex items-center justify-center hover:text-[var(--primary)] shadow-sm transition-all hover:scale-110 cursor-pointer"><i class="fa-solid fa-envelope"></i></a>

            </div>

            <p>&copy; 2025 Davidson Linhares. Built with Angular 18, Tailwind & GitHub API.</p>

          </div>

        </footer>

  

      </div>

    </div>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

  `,

  styles: [`

    :host { display: block; }

    /* Utilitário para animação de scroll */

    .opacity-0-forced { opacity: 0; transform: translateY(30px); }

    .animate-in { animation: fadeInUp 0.8s cubic-bezier(0.2, 0.8, 0.2, 1) forwards; }

  

    @keyframes fadeInUp {

      to { opacity: 1; transform: translateY(0); }

    }

    @keyframes slideDown {

      from { opacity: 0; transform: translateY(-10px); }

      to { opacity: 1; transform: translateY(0); }

    }

    .animate-slide-down { animation: slideDown 0.3s ease-out forwards; }

    .animate-pulse-slow { animation: pulse 6s cubic-bezier(0.4, 0, 0.6, 1) infinite; }

    .text-primary-gradient {

      background: linear-gradient(to right, var(--primary), var(--secondary));

      -webkit-background-clip: text;

      color: transparent;

    }

    .bg-dots {

      background-image: radial-gradient(currentColor 1px, transparent 1px);

      background-size: 20px 20px;

    }

  `]

})

export class App implements OnInit {

  // Injeções de dependência

  http = inject(HttpClient);

  platformId = inject(PLATFORM_ID);

  

  // Estados Reativos (Signals)

  isMenuOpen = signal(false);

  navClass = signal('bg-transparent');

  darkMode = signal(true);

  activeJobIndex = signal<number | null>(0); // Primeiro item aberto por padrão

  

  // Dados da API GitHub

  githubProfile = signal<GithubProfile | null>(null);

  githubRepos = signal<GithubRepo[]>([]);

  loadingGithub = signal(true);

  

  // Configuração de Temas (Cores)

  themes: Theme[] = [

    { name: 'Emerald', primary: '#10b981', secondary: '#06b6d4', accent: '#34d399' },

    { name: 'Violet',  primary: '#8b5cf6', secondary: '#6366f1', accent: '#a78bfa' },

    { name: 'Blue',    primary: '#3b82f6', secondary: '#0ea5e9', accent: '#60a5fa' },

    { name: 'Rose',    primary: '#f43f5e', secondary: '#e11d48', accent: '#fb7185' },

    { name: 'Amber',   primary: '#f59e0b', secondary: '#d97706', accent: '#fbbf24' },

  ];

  currentTheme = signal<Theme>(this.themes[0]);

  

  // Dados para os gráficos de skills

  skillStats = [

    { name: 'Java / Spring Boot', level: 95, inView: false },

    { name: 'AWS & Cloud', level: 80, inView: false },

    { name: 'Docker / Kubernetes', level: 75, inView: false },

    { name: 'Architecture Design', level: 85, inView: false },

    { name: 'Frontend (Angular/React)', level: 60, inView: false }

  ];

  

  // Elementos para observar no scroll

  @ViewChildren('animateItem') animateItems!: QueryList<ElementRef>;

  

  // Dados do Portfólio (Editáveis)

  portfolioData = {

    name: "Davidson de Souza Linhares",

    role: "Desenvolvedor Backend Java | DevOps",

    profileImage: "image_0085a2.jpg",

    skills: [

      "Java 17/21", "Spring Boot 3", "Microservices", "AWS (EC2, S3, RDS)",

      "Docker", "Terraform", "PostgreSQL", "Clean Architecture",

      "CI/CD (GitHub Actions)", "React", "Python"

    ],

    experience: [

      {

        role: "Fundador & Full Stack Developer",

        company: "ByeBye Cupom!",

        period: "Presente",

        highlight: true,

        description: "Plataforma SaaS voltada à digitalização de cupons fiscais (NFC-e).\n\n• Arquitetura Cloud-Native escalável na AWS.\n• Implementação de API RESTful segura.\n• Motor de conversão XML e geração de QR Code.\n• Integração futura com Open Finance.",

        tech: ["Java", "Spring Boot", "React", "AWS", "Docker", "PostgreSQL"]

      },

      {

        role: "Analista de Suporte II",

        company: "Telemática (Volkswagen)",

        period: "05/2024 - Presente",

        highlight: false,

        description: "Atuação na planta da Volkswagen Caminhões e Ônibus.\n\n• Monitoramento crítico de infraestrutura.\n• Suporte a sistemas de controle de acesso de alta disponibilidade.",

        tech: ["Infraestrutura", "Monitoramento", "SLA Management"]

      },

      {

        role: "Técnico de Apoio",

        company: "Algar TI (Nissan)",

        period: "2022 – 2023",

        highlight: false,

        description: "Atendimento técnico na fábrica Nissan Resende.\n\n• Resolução de incidentes críticos de produção.\n• Manutenção de hardware e software industrial.",

        tech: ["Service Desk", "ITIL", "Hardware"]

      },

       {

        role: "Supervisor Administrativo",

        company: "Flix Telecom",

        period: "2021",

        highlight: false,

        description: "Liderança de equipe e análise de dados.\n\n• Gestão de equipe de 7 pessoas.\n• Análise de dados de 4k ordens de serviço/mês com VBA para otimização de rotas.",

        tech: ["Liderança", "VBA", "Analytics"]

      }

    ]

  };

  

  ngOnInit() {

    // Executar apenas no navegador para evitar erros de SSR/Build time

    if (isPlatformBrowser(this.platformId)) {

       this.fetchGithubData();

       this.setupIntersectionObserver();

    }

  }

  

  // Busca dados reais do GitHub

  fetchGithubData() {

    const username = 'DavJaveiro';

    // Perfil

    this.http.get<GithubProfile>(`https://api.github.com/users/${username}`).subscribe({

      next: (data) => this.githubProfile.set(data),

      error: () => console.error('Erro ao carregar perfil GitHub')

    });

  

    // Repositórios

    this.http.get<GithubRepo[]>(`https://api.github.com/users/${username}/repos?sort=updated&per_page=6`).subscribe({

      next: (data) => {

        this.githubRepos.set(data);

        this.loadingGithub.set(false);

      },

      error: () => this.loadingGithub.set(false)

    });

  }

  

  // Configura animação ao rolar a página

  setupIntersectionObserver() {

    const observer = new IntersectionObserver((entries) => {

      entries.forEach(entry => {

        if (entry.isIntersecting) {

          entry.target.classList.add('animate-in');

          entry.target.classList.remove('opacity-0-forced');

          // Ativa animação das barras de progresso

          this.skillStats.forEach(stat => {

             setTimeout(() => stat.inView = true, 500);

          });

          observer.unobserve(entry.target);

        }

      });

    }, { threshold: 0.1 });

  

    // Aguarda renderização para capturar elementos

    setTimeout(() => {

      this.animateItems.forEach(item => {

        item.nativeElement.classList.add('opacity-0-forced');

        observer.observe(item.nativeElement);

      });

    }, 100);

  }

  

  @HostListener('window:scroll', [])

  onWindowScroll() {

    this.navClass.set(window.scrollY > 50

      ? 'bg-white/90 dark:bg-slate-950/90 backdrop-blur-md shadow-lg'

      : 'bg-transparent');

  }

  

  toggleMenu() {

    this.isMenuOpen.update(v => !v);

  }

  

  toggleDarkMode() {

    this.darkMode.update(v => !v);

  }

  

  setTheme(theme: Theme) {

    this.currentTheme.set(theme);

  }

  

  toggleJob(index: number) {

    this.activeJobIndex.update(current => current === index ? null : index);

  }

  

  scrollTo(elementId: string): void {

    const element = document.getElementById(elementId);

    if (element) {

      element.scrollIntoView({ behavior: 'smooth', block: 'start' });

    }

  }

}