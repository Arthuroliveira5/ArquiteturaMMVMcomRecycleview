🧠 Arquitetura MVVM com RecyclerView
Este é um projeto Android que demonstra a implementação da arquitetura MVVM (Model–View–ViewModel) utilizando RecyclerView para exibição dinâmica de dados, de forma desacoplada e escalável.

🏗 Arquitetura
O projeto segue o padrão MVVM com os seguintes componentes principais:

🔹 View
Representada pela MainActivity, é responsável por exibir a interface do usuário e interagir com o ViewModel.

🔸 ViewModel
Implementada por MainViewModel, gerencia os dados da interface e a lógica de apresentação.

🔹 Model
Representado pelo MainRepository e pelas fontes de dados (API, serviços locais, etc).

🔸 Repository
MainRepository atua como uma ponte entre o ViewModel e os dados, organizando e fornecendo-os à UI.

🚀 Tecnologias Utilizadas
Kotlin – Linguagem moderna e concisa para o desenvolvimento Android.

Android Architecture Components – Conjunto de bibliotecas de arquitetura recomendadas pelo Google.

ViewModel – Mantém e gerencia os dados relacionados à UI.

LiveData – Permite a observação de dados reativos e atualizações automáticas da interface.

RecyclerView – Componente flexível para renderização de listas.

Retrofit – Biblioteca para requisições HTTP e integração com APIs RESTful.

📁 Estrutura do Projeto
plaintext
Copiar
Editar
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.arquiteturammvmcomrecycleview/
│   │   │       ├── MainActivity.kt
│   │   │       ├── repository/
│   │   │       │   └── MainRepository.kt
│   │   │       └── viewmodel/
│   │   │           ├── MainViewModel.kt
│   │   │           └── MainViewModelFactory.kt
│   │   └── res/
│   └── test/
└── build.gradle
✅ Funcionalidades
Estrutura limpa com arquitetura MVVM.

Exibição eficiente de listas com RecyclerView.

Gerenciamento de estado da UI com ViewModel e LiveData.

Integração com serviços web utilizando Retrofit.

📄 Licença
Este projeto está licenciado sob os termos da MIT License.

