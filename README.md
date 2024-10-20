# Projeto de Ensino: Testes End-to-End (E2E) com Espresso

Este projeto foi desenvolvido como um material de apoio para aulas de testes End-to-End (E2E) com **Espresso**, a biblioteca de testes de UI do Android. O objetivo deste projeto é proporcionar aos alunos uma compreensão prática sobre como criar, organizar e executar testes E2E para aplicativos Android utilizando Espresso.


## Objetivos

- Entender os conceitos básicos de testes de interface do usuário (UI).
- Aprender a configurar o ambiente de testes usando Espresso.
- Escrever testes de UI automatizados que simulam interações do usuário em um app Android.
- Aplicar boas práticas para organizar e estruturar testes em projetos de larga escala.
- Aprender a utilizar o **Robot Pattern** para melhorar a legibilidade e manutenibilidade dos testes.

## Requisitos

- Conhecimento básico de desenvolvimento Android com Kotlin.
- Android Studio 4.0 ou superior.
- Emulador Android ou dispositivo físico com USB Debugging ativado.

## Instalação

1. Clone o repositório:

    ```bash
    git clone https://github.com/jacksonsmith/android_investments_e2e_tests.git
    cd android_investments_e2e_tests
    ```

2. Abra o projeto no Android Studio.

3. Execute o comando `Sync Project with Gradle Files` para garantir que todas as dependências estão atualizadas.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
src
 └── androidTest
      ├── helpers
      │    └── MainActivityRobot.kt      // Implementação do Robot Pattern
      ├── cases
      │    └── MainActivityE2ETests.kt   // Testes end-to-end
      ├── screens
      │    └── MainActivityUITests.kt    // Testes de interface de usuário (UI)
```

- **helpers/**: Contém classes utilitárias, como a implementação do **Robot Pattern**, que encapsula interações repetitivas da UI.
- **cases/**: Testes E2E organizados para diferentes partes da aplicação.
- **screens/**: Testes de UI específicos para as telas do aplicativo.

## Criando Seu Primeiro Teste com Espresso

### 1. Adicionando as Dependências

Verifique se as seguintes dependências estão adicionadas no arquivo `build.gradle`:

```gradle
androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
androidTestImplementation 'androidx.test.ext:junit:1.1.3'
```

### 2. Estruturando o Teste com o Robot Pattern

Exemplo de como um teste básico pode ser estruturado:

```kotlin
@Test
fun testMXRF11OnInvestmentAndWalletScreen() {
    // Simulate interaction on the "Earnings" tab
    robot.clickOnEarningsTab()
    // Verify that the MXRF11 investment card is visible
    robot.verifyInvestmentCardIsDisplayed("MXRF11")

    // Simulate switching to the "Wallet" tab
    robot.clickOnWalletTab()
    // Verify that the MXRF11 entry is visible in the wallet
    robot.verifyWalletEntryIsDisplayed("MXRF11")
}
```

### 3. Executando Testes

Para executar os testes:

1. Abra o Android Studio.
2. Vá até a aba `Run` e selecione `Run All Tests` ou execute um teste específico clicando no ícone de teste ao lado do método de teste.

Os resultados aparecerão no painel de `Run` com informações detalhadas sobre cada execução, incluindo sucesso ou falha.

## Boas Práticas

1. **Robot Pattern**: Use o Robot Pattern para separar a lógica dos testes e melhorar a manutenibilidade.
2. **Testes Isolados**: Cada teste deve cobrir um cenário único para que falhas sejam facilmente identificáveis.
3. **Estrutura Modular**: Mantenha os testes organizados em pastas para garantir escalabilidade à medida que o projeto cresce.
4. **Evite Testes Dependentes**: Os testes não devem depender uns dos outros. Cada teste deve ser capaz de ser executado de forma independente.

## Recursos

- [Documentação Oficial do Espresso](https://developer.android.com/training/testing/espresso)
- [Artigo sobre Robot Pattern](https://medium.com/android-testing/android-testing-with-the-robot-pattern-7a7f45f85e27)
- [Boas Práticas em Testes Android](https://developer.android.com/training/testing)

## Contribuições

Contribuições são bem-vindas! Se você encontrar bugs ou tiver sugestões de melhoria, fique à vontade para abrir uma **issue** ou enviar um **pull request**.

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para mais detalhes.
```

### GitHub do Projeto:
[https://github.com/jacksonsmith/android_investments_e2e_tests](https://github.com/jacksonsmith/android_investments_e2e_tests)

--- 
