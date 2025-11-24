````markdown
# 🏠 Java ML - Previsão de Preços Imobiliários

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Weka](https://img.shields.io/badge/Weka-Machine%20Learning-blue?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Project-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

> Um sistema inteligente que utiliza **Machine Learning (Regressão Linear)** para prever o valor de mercado de imóveis com base em características como área, número de quartos e presença de garagem.

---

## 🖥️ Demonstração no Console

O sistema interage com o utilizador, coleta os dados e fornece uma estimativa em tempo real:

```text
============================================
   🤖  SIMULADOR IMOBILIÁRIO PRO (v3.0)  
============================================
1. Área (m²): 120
2. Nº de Quartos: 3
3. Tem Garagem? (1=SIM, 0=NÃO): 1
--------------------------------------------
   🏠 Com Garagem | 120m² | 3 Quartos 
   💰 AVALIAÇÃO: R$ 450.000,00 
--------------------------------------------

Nova simulação? (S/N): 
````

-----

## 🚀 Funcionalidades

  * **🧠 Aprendizagem Automática:** O sistema lê um histórico de vendas (`casas.arff`) e aprende os padrões de preço sozinho.
  * **💾 Persistência de Dados:** O "cérebro" da IA é salvo num arquivo (`imobiliaria.model`). Se o arquivo já existir, o sistema carrega-o instantaneamente sem precisar retreinar.
  * **🗣️ Interatividade:** Interface via console amigável que permite múltiplas simulações numa única execução.
  * **📈 Engenharia de Atributos:** O modelo considera fatores valorizados pelo mercado, como a existência de garagem.

-----

## 🛠️ Tecnologias Utilizadas

  * **Java (JDK 17+):** Linguagem principal.
  * **Weka (3.8.6):** Biblioteca de Machine Learning e Mineração de Dados.
  * **Apache Maven:** Gestão de dependências e build.
  * **Eclipse IDE:** Ambiente de desenvolvimento.
  * **Git/GitHub:** Versionamento de código.

-----

## 📂 Estrutura do Projeto

| Arquivo / Pasta | Descrição |
| :--- | :--- |
| `src/main/java` | Código fonte da aplicação (`PrevisaoPrecoImoveis.java`). |
| `casas.arff` | **Dataset:** Base de dados histórica usada para o treino. |
| `imobiliaria.model` | **O Modelo:** Arquivo gerado após o treino (o cérebro salvo). |
| `pom.xml` | Configuração do Maven e dependência do Weka. |

-----

## ⚙️ Como executar o projeto

### Pré-requisitos

  * Java instalado.
  * Eclipse (ou outra IDE) com suporte a Maven.

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SEU-USUARIO/Java-ml-previsao-imoveis.git](https://github.com/SEU-USUARIO/Java-ml-previsao-imoveis.git)
    ```
2.  **Importe no Eclipse:**
      * `File` \> `Import` \> `Maven` \> `Existing Maven Projects`.
3.  **Atualize as dependências:**
      * Clique direito no projeto \> `Maven` \> `Update Project`.
4.  **Execute:**
      * Abra `PrevisaoPrecoImoveis.java` e execute como `Java Application`.

-----

## 🧠 Como funciona a IA?

O projeto utiliza o algoritmo de **Regressão Linear**.
Imagine que o computador tenta desenhar uma linha num gráfico que passe o mais perto possível de todos os preços conhecidos.
A fórmula aprendida é algo semelhante a:

$$Preço = (Peso_{Area} \times Area) + (Peso_{Quartos} \times Quartos) + (Peso_{Garagem} \times Garagem) + Base$$

-----

## 👨‍💻 Autor

Desenvolvido por **Bruno Assis** durante estudos de integração entre Java e Inteligência Artificial.

-----

*Este projeto é para fins educativos.*

```
```
