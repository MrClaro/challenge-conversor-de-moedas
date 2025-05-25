# 💰 Segundo Challenge - Oracle Next Education (ONE)

Neste desafio, desenvolvemos uma aplicação simples e interativa de **Conversor de Moedas** que opera via console, proporcionando aos usuários múltiplas opções de conversão e taxas atualizadas em tempo real. Este projeto faz parte do programa de aprendizado do ONE e é um excelente exercício para consolidar todos conhecimento adquiridos ao longo da Formação Java e Orientação à Objetos.

## 📜 Descrição do Projeto

A aplicação permite que os usuários escolham entre pelo menos 6 opções diferentes de conversão de moedas utilizando um menu textual no console. As taxas de conversão são obtidas dinamicamente por meio da **Exchange Rate API**, garantindo dados precisos e atualizados para uma experiência mais confiável.

As principais funcionalidades do projeto incluem:

- Menu interativo com no mínimo 6 opções de conversão de moedas.
- Consumo dinâmico de taxas de câmbio em tempo real via **Exchange Rate API**.
- Exibição clara e amigável dos resultados das conversões no console.
- Histórico das últimas conversões realizadas, para que o usuário possa acompanhar suas operações.
- Suporte ampliado para mais moedas, oferecendo uma ampla variedade de opções para conversão.

### 🏗️ Arquitetura e Design
Para garantir uma integração eficiente e centralizada com a API de conversão, foi utilizado o padrão de projeto **Singleton** na implementação da classe responsável por consumir a Exchange Rate API. Assim, há apenas uma instância de acesso à API durante todo o ciclo de vida da aplicação, otimizando o uso de recursos e facilitando a manutenção.

## 🛠️ Funcionalidades

✅ **Menu Interativo**

O usuário pode escolher facilmente qual conversão deseja realizar entre diferentes opções disponíveis.

✅ **Conversão em tempo real**

As taxas de câmbio são consultadas diretamente na **Exchange Rate API** a cada conversão, garantindo valores atualizados.

✅ **Histórico de Conversões**

O sistema mantém o registro das últimas conversões feitas, permitindo que o usuário visualize seu histórico recente.

✅ **Suporte a Diversas Moedas**

É possível converter entre várias moedas, tornando a aplicação útil para diferentes necessidades.

✅ **Consumo e análise de JSON**

A resposta da API é tratada e os dados necessários são extraídos utilizando a biblioteca **Gson** para facilitar o processamento.

## 🚀 Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java:** Linguagem principal utilizada para toda a lógica da aplicação.
- **Gson:** Biblioteca para análise e manipulação de respostas JSON.
- **Exchange Rate API:** Fonte dos dados de taxas de câmbio em tempo real.
- **Design Pattern Singleton:** Usado para garantir uma única instância da classe de acesso à API.

## 🔧 Como executar o projeto?

Clone este repositório em sua máquina:

```bash
git clone https://github.com/MrClaro/challenge-conversor-de-moedas.git
```

Compile e execute o projeto utilizando sua IDE de preferência ou via terminal:

```bash
# Compile os arquivos Java
javac -cp gson-2.8.9.jar src/Main.java

# Execute a aplicação (ajuste o caminho para o .jar da gson conforme necessário)
java -cp .;gson-2.8.9.jar src/Main
```

Certifique-se de ter a biblioteca **gson** disponível no classpath.

## 🏆 Desafio do Programa ONE

Este projeto é o segundo desafio do programa Oracle Next Education e foi projetado para consolidar os conhecimentos iniciais em desenvolvimento com Java, incluindo:

- Consumo de APIs externas e manipulação de dados em JSON.
- Estruturação de menus interativos via console.
- Manipulação de listas e histórico de operações.
- Boas práticas de validação e exibição de dados para o usuário.
- Implementação de padrões de projeto como Singleton.

## 🤝 Contribuição

Fique à vontade para sugerir melhorias ou enviar pull requests! Sua contribuição é sempre bem-vinda. 😊

## 📄 Licença

Este projeto foi desenvolvido como parte de um programa educacional e está livre para uso pessoal e educacional.
