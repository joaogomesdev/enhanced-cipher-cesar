# Projeto Enchanced Caesar

---

| Aluno | João Pedro Ferreira Gomes |
| --- | --- |
| Número | 1200365 |
| Cadeira | Segurança de Aplicações e Dados |

---

## Definição do projeto

---

O projeto Enchanced Caesar foi feito para a cadeira de Segurança de Aplicações e Dados (SAD) no 1º Semestre do ano lectivo de 2021/2022 a pedido dos professores Marcelo Santos e Vladir Vicente.

Os objetivos do projeto são:

- A implementação de uma Cifra de Caesar modificada.
- A implementação da Enigma modificada.
- Realizar um ataque Brute-force.
- Realizar um ataque ao Dicionário.

Ferramentas usadas:

- Java como linguagem usada.
- Intellij como IDE usada.
- Terminal para fazer o build e o run do algoritmo.

## Planeamento

A primeira etapa do projeto foi a interpretação do enunciado e todo o material fornecido pelos professores, onde em seguida foi feita toda a pesquisa necessaria.

![Fluxo do algoritmo](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled.png)

Fluxo do algoritmo

## Execução

---

### Ponto inicial

Para a execução começei por dividir cada parte de todo o fluxo, começando pela leitura dos inputs disponibilidados no terminal.

Para isso utilizei o seguinte código abaixo:

![Untitled](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%201.png)

Esta função main esta na classe principal do projeto, onde vai ser o ponto inicial de tudo.

Com o seguinte codigo fui buscar o que desejava ao parametro da função , que no caso é um array de String e cada posição corresponde a um argumento que nos passamos.

Paramentros recebidos:

- Hash do aluno
- Plugboard do aluno
- Caminho para o arquivo de leitura

Esses dados são guardados nas variaveis da classe pincipal, juntamente com outras para ajuda.

![Untitled](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%202.png)

### WordListParser

Esta classe esta encarregada de ir ao ficheiro com o caminho disponibilizado e guardar todas as linhas do ficheiro numa Lista de Strings, escolhi o Lista para melhor manipulação de dados.

![Codigo da leitura do ficheiro](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%203.png)

Codigo da leitura do ficheiro

![Etapa do fluxo](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%204.png)

Etapa do fluxo

**Passos realizados no código:**

- Criação de uma lista vazia para preenchimento futuro.
- Abertura de um bloco try/catch para a tratativa de possiveis erros
- Criação de um objeto de ficheiro com o caminho obtido
- Ciclo while que enquanto houverem linhas no ficheiro ele vai pegar nessa linha e preencher o wordList com as mesmas
- No fim retornamos essa lista e fechamos o Scanner

### SaltGenerator

Depois de termos uma lista carregada com todas as palavras vamos gerar um **salt** para cada uma das palavras, ou seja, um conjunto de caracteres  adicionados a palavra carregada.

Neste caso serão dois caracteres, a direita e a esquerda, esses caracteres foi ser gerados de acordo com o alfabeto disponibilizado: **“ABCDEFGHIJKLM”**

Todas as possibilidades com todas as palavras tem de ser testadas e para isso foi utilizado o seguinte código:

![Untitled](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%205.png)

**Pontos realizados no código:**

- Ciclo for que vai percorrer as palavras do ficheiro e testar o fluxo com o salt posicionado a direita.
- Ciclo for que vai percorrer as palavras do ficheiro e testar o fluxo com o salt posicionado a esquerda.
- Atribuição do valor **‘currentWord’** para no futuro sabemos qual a palavra original que nos foi atribuida

A geração do salt é igual nas duas funções com a pequena diferença de uma colocar o salt a direita e a outra a esquerda.

![Untitled](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%206.png)

![Etapa do fluxo](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%207.png)

Etapa do fluxo

**Pontos realizados no código:**

- A função recebe a palavra e a plugboard para futura utilização.
- Pequena validação da hash
- Dois ciclos **for:**
    - 1 para a primeira letra
    - 2 para a segunda letra
    - Fazendo assim uma geração → AA , AB, AC, AD ... BA, BB , BC, BD .... MM
- Concatenação do salt com a palavra
- Atribuição do valor **‘currentSaltBeforePlugboard’** para futura utilização
- Depois da geração do salt completo é chamada a classe **‘PlugboardParser’**  que vai ser responsavel pelo proximo passo

### PlugboardParser

Esta classe esta responsavel por vazer a leitura da plugboard disponibilizada e depois comparar os valores da palavra com o salt e substituir as respetivas letras de acordo com a disponibilização do plugboard.

O plugboard esta no formato de JSON onde existe a **chave** e o **valor,** sendo a **chave** a letra que temos de identificar na palavra e  o valor que temos de substituir.

![Untitled](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%208.png)

**Pontos realizados no código:**

- Formatação da plugboard para o formato de Array com 2 posições para melhor manipulação.
- Geração do valor apos ter passado pela plugboard.
- Atribuição do valor **‘currentSaltAfterPlugboardBeforeCesar**’ para utilização futura.
- É chamada a classe **‘EnchancedCesar’**  para o passo seguinte.

![Untitled](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%209.png)

![Etapa do fluxo](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%2010.png)

Etapa do fluxo

**Pontos realizados no código:**

- Substituição dos valores da plugboard.

### **EnchancedCesar**

Esta classe esta responsavel pela implementação do algoritmo Caesar melhorado.

![Untitled](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%2011.png)

![Etapa do fluxo](https://i.imgur.com/troVIJp.png)

Etapa do fluxo

**Pontos realizados no código:**

- Esta função esta responsavel por gerar todas as combinações de rotores e incrementos, que é a grande diferença para o Caesar normal.
- É chamada a classe **‘PlugboardParser’**  onde vamos devolver a cifra a plugboard.

![https://i.imgur.com/OzUgalX.png](https://i.imgur.com/OzUgalX.png)

![Etapa do fluxo](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%2012.png)

Etapa do fluxo

**Pontos realizados no código:**

- Esta funcão esta responsavel por aplicar o algoritmo de caesar modificado.
- Criamos um StringBuilder para construir a nova palavra.
- Ciclo for que vai percorrer a palavra e aplicar a cifra
    - Guardamos o incremento atual, que a medica que o ciclo vai se repetir o mesmo vai autentar→ inc [index] = index * F
    - Guardamos a posição da letra onde é igual no alfabeto.
    - Calculamos a nova posição da letra.
    - Guardamos a posição da letra no alfabetos.
    - Fazemos a substituição da letra.
- Repornamos a nova palavra cifrada.

### Segunda passagem pela plugboard

Nesta etapa pegamos na cifra gerada pelo EnchancedCaesar e usamos a classe de hash para fazer o hash do resultado.

![https://i.imgur.com/Cqmy54C.png](https://i.imgur.com/Cqmy54C.png)

**Pontos realizados no código:**

- Fazemos o parse da cifra no EnchancedCaesar.
- Geramos a hash **SHA-512**
- Validamos se a hash gerada é igual a que nos foi atribuida

### Sha512Hasher

Nesta classe é gerada a hash **SHA-512**

![Untitled](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%2013.png)

![Etapa do fluxo](Projeto%20Enchanced%20Caesar%209b36023a8de0449d9b0f648cba61bac7/Untitled%2014.png)

Etapa do fluxo

**Pontos realizados no código:**

- Utilização da biblioteca **MessageDigest** que vem com o java que providencia funçóes seguras para a geração de varios tipos de hash.

## Resultado

---

### Input inserido

```bash
java BreakingEnigma  4ef49689665c22e413ceec2a45d2e6f40b069ea464c3484f13cb48580611da2fa6bca1f81c414fb1f480c2e892d3644db66378fa28e8fc2a811f8a48fdb9cb3d "{'M': 'N', 'Q': 'J', 'I': 'C', 'O': 'A', 'R': 'S', 'K': 'U', 'P': 'F', 'E': 'Y', 'H': 'V', 'B': 'L'}" ./wordlist.txt
```

### **Output**

```bash

        ---==/    \\
             |.    \|\  
             |  )   \\\   
             \_/ |  //|\\ 
                  /   \\\/\\
Your word is -> TDUTIF
Your salt before plugboard is -> TDUTIFFE
Your salt after plugboard and before EnchancedCesar -> TDUTCFFY
Your salt after EnchancedCesar and before the second plugboard is -> PGEKAKRR
Your salt after second plugboard is -> FGYUAUSS
Your generated hash  is  -> 4ef49689665c22e413ceec2a45d2e6f40b069ea464c3484f13cb48580611da2fa6bca1f81c414fb1f480c2e892d3644db66378fa28e8fc2a811f8a48fdb9cb3d
Your expected  hash  is  -> 4ef49689665c22e413ceec2a45d2e6f40b069ea464c3484f13cb48580611da2fa6bca1f81c414fb1f480c2e892d3644db66378fa28e8fc2a811f8a48fdb9cb3d
```

# Sources

---

## Repositorio do projeto

[GitHub - JoaoGomes5/enhanced-cipher-cesar: O projeto Enchanced Caesar foi feito para a cadeira de Segurança de Aplicações e Dados (SAD) no 1º Semestre do ano lectivo de 2021/2022 a pedido dos professores Marcelo Santos e Vladir Vicente.](https://github.com/JoaoGomes5/enhanced-cipher-cesar)

## Caesar Cipher

[](https://www.dcode.fr/caesar-cipher)

## SHA-512

[SHA-512 Hash In Java - GeeksforGeeks](https://www.geeksforgeeks.org/sha-512-hash-in-java/)

## Material fornecido pelos professores

[MoodleISEP](https://moodle.isep.ipp.pt/pluginfile.php/169476/mod_resource/content/4/Enunciado.pdf)

## Enigma

[The Enigma Machine Explained](https://www.youtube.com/watch?v=ASfAPOiq_eQ&t=7s)