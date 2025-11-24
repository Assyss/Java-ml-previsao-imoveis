package com.estudos.imoveis;

import java.io.File;
import java.util.Scanner;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.DenseInstance;

public class PrevisaoPrecoImoveis {

    public static void main(String[] args) {
        try {
            // PREPARAÇÃO DOS DADOS (Necessário para estrutura)
            // Precisamos ler o ARFF apenas para saber os nomes das colunas (estrutura)
            DataSource source = new DataSource("casas.arff");
            Instances dataset = source.getDataSet();
            dataset.setClassIndex(dataset.numAttributes() - 1);

            // ETAPA 1: CARREGAR OU TREINAR O MODELO          
            LinearRegression modelo;
            String caminhoModelo = "imobiliaria.model";

            // Verificamos se o "cérebro" já existe no computador
            if (new File(caminhoModelo).exists()) {
                System.out.println("Modelo encontrado! A carregar memória...");
                // Carrega o modelo pronto (Rápido!)
                modelo = (LinearRegression) SerializationHelper.read(caminhoModelo);
            } else {
                System.out.println("Modelo não existe. A treinar do zero...");
                // Cria e Treina (Lento...)
                modelo = new LinearRegression();
                modelo.buildClassifier(dataset);
                
                // Salva no disco para a próxima vez
                System.out.println(" A salvar o conhecimento em '" + caminhoModelo + "'...");
                SerializationHelper.write(caminhoModelo, modelo);
            }

            System.out.println("IA Pronta para uso!");

            // ETAPA 2: INTERAÇÃO
            Scanner leitor = new Scanner(System.in);
            String continuar; 

            do {
                System.out.println("\n============================================");
                System.out.println("   SIMULADOR IMOBILIÁRIO PRO (v3.0)  ");
                System.out.println("============================================");
                
                System.out.print("1. Área (m²): ");
                double area = leitor.nextDouble();
                
                System.out.print("2. Nº de Quartos: ");
                double quartos = leitor.nextDouble();
                
                System.out.print("3. Tem Garagem? (1 = SIM, 0 = NÃO): ");
                double garagem = leitor.nextDouble();

                // Criação da instância para previsão
                Instance novaCasa = new DenseInstance(4); 
                novaCasa.setDataset(dataset);
                novaCasa.setValue(0, area);
                novaCasa.setValue(1, quartos);
                novaCasa.setValue(2, garagem);

                double precoPrevisto = modelo.classifyInstance(novaCasa);

                String textoGaragem = (garagem == 1) ? "Com Garagem" : "Sem Garagem";
                System.out.println("--------------------------------------------");
                System.out.printf("   %s | %.0fm² | %.0f Quartos %n", textoGaragem, area, quartos);
                System.out.printf("   AVALIAÇÃO: R$ %,.2f %n", precoPrevisto);
                System.out.println("--------------------------------------------");

                System.out.print("\nNova simulação? (S/N): ");
                continuar = leitor.next(); 

            } while (continuar.equalsIgnoreCase("S"));

            System.out.println("\nSistema encerrado.");
            leitor.close();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}