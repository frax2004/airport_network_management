# Laboratorio di Algoritmi


### AVL
##### Definizioni
- **fattore di bilanciamento**: modulo della differenza delle altezze dei sottoalberi sinistro e destro di un nodo.
- **albero bilanciato in altezza**: albero in cui ogni nodo ha un fattore di bilanciamento al piu 1.

##### Teorema
Un albero AVL con n nodi ha altezza $\Theta(n)$

##### Dimostrazione
Il numero minimo di nodi per alberi con altezza h e':
per $h = 0$, $n_h = 1$.
per $h = 1$, $n_h = 2$.
per $h = 2$, $n_h = 4$.

In generale, per $h \geq 2$, $n_h = 1 + n_{h-1} + n_{h-2}$, e per la legge di fibonacci, e' noto che $h \approx 1.44log(n_h + 2)-0.328$

Per un generico albero AVL con $n$ nodi e altezza $h$, si ha che $n_h \lt n$ da cui si ha che $h = \Theta(\log n)$.

Per avere un bilanciamento perfetto, anche il numero dei nodi dei due sottoalberi deve differire al piu 1.
Il segno di tale differenza indica la direzione dello sbilanciamento.

Implementazione:
- **ricerca**: identica alla ricerca BST.
- **inserimento/cancellazione**: BST + rotazioni per mantenere il bilanciamento.

La **rotazione** e' un operazione locale che prende al piu tempo **costante**. Il numero di rotazioni totali in un' operazione di inserimento o cancellazione e' $O(h) = O(\log n)$.

##### Teorema
Un albero AVL con n nodi ha altezza $O(\log n)$. La cancellazione o l'inserimento necessita al piu di O(\log n) rotazioni.

### Albero di ricerca 2-3
Un albero 2-3 e' un albero nel quale ogni nodo interno ha 2 o 3 figli e la visita simmetrica produce gli elementi in ordine crescente (ogni sottoalbero di sinistra di un nodo ha chiavi $\leq$ e ogni sottoalbero di destra di un nodo ha chiavi $\gt$).

Due possibili implementazioni:
- i nodi interni contengono le informazioni direttamente
- i nodi interni contengono puntatori alle informazioni presenti esclusivamente nella frontiera.

##### Teorema
Sia T un albero 2-3 con n nodi, f foglie e altezza h, valgono le seguenti disuguaglianze:
- $2^{h+1} \leq n \leq \frac{3^{h+1}-1}{2}$
- $2^h \leq f \leq 3^h$

##### Dimostrazione
Si prova per induzione su $h$. Se $h = 0$ l'albero jha un solo nodo ed e' anche foglia.
Se la proposizione e' vera per un albero 2-3 $T$ di altezza $h$ allora un albero $T^{'}$ ottenuto eliminando la frontiera da $T$ avra' una frontiera che in T rappresenta l'ultimo livello prima della frontiera e dalla definizione di albero 2-3, ogni nodo ha 2 o 3 figli, quindi $T$ ha $2 \times 2^h \leq f \leq 3 \times 3^h$ foglie.

Inoltre, $h=\Theta(\log n)$.

Operazioni:
- **ricerca**: simile a quella degli abr, ma ogni nodo puo' fare 2 o 3 confronti in quanto ha 2 o 3 figli.
- **inserimento in un 2-nodo**: basta inserire l'elemento
- **inserimento in un 3-nodo**: il nodo diventa temporaneamente un 4-nodo, poi si rende l'elemento centrale padre degli altri 2 elementi e si procede ricorsivamente fino alla radice (max $O(\log n)$) per mantenere le proprieta' di albero 2-3. (tutte trasformazioni locali $\implies O(1)$).
- **cancellamento in un 3-nodo**: basta cancellare l'elemento
- **cancellamento in un 2-nodo**: se i figli sono entrambi 2-nodi si crea un nodo-4 temporaneo, altrimenti si trasferisce un elemento dal 3-nodo al 2-nodo da cui e' stato cancellato l'elemento. Risalendo ricorsivamente si aggiustano i 4-nodi temporaneamente creati. Si sostituisce il nodo radice del sottoalbero con il successore suo(il nuovo minimo).

- l'altezza dell'albero cambia solo quando la radice viene invalidata, ma cosi' viene incrementata (o decrementata) di 1 la lunghezza di ogni cammino radice foglia.

Complessita': 
- inserimento, cancellazione e ricerca logaritmici nel numero dei nodi.

La loro implementazione e' complicata per via dei vari casi su ogni nodo.

### Alberi rosso neri
Sono una variante degli alberi 2-3 che codificano i nodi-3 mediante l'aggiunta di un colore per i nodi.
- I nodi rossi sono orientati a sinistra
- Nessun nodo ha due archi rossi ad esso conneso.
- L'albero ha bilanciamento perfetto nero: ogni cammino radice foglia ha lo stesso numero di link neri.

Rappresentazione:
- radice e' nera
- ogni foglia e' nera, non contiene informazioni e contiene un linkl nullo
- se un nodo e' rosso allora entrambi i suoi figli sono neri
- ogni cammino radice foglia ha lo stesso numero di nodi neri.

##### Teorema
L'altezza di un albero di ricerca RB con $N$ nodi e' $\Theta(\log N)$.

##### Dimostrazione
Il caso peggiore e' il caso in cui tutti i nodi sono 2-nodi tranne il percorso piu a sinistra che ha tutti 3-nodi.
Il percorso piu' lungo e' lungo al piu' il doppio del percorso piu' breve, quindi rimane $O(2\log n)$ per costruzione.

##### Lemma 1
In un albero rosso nero per ogni nodo $x$: $blackheight(x) \geq \frac{height(x)}{2}$

##### Dimostrazione
Ogni nodo rosso ha un padre nero, quindi al piu la meta' dei nodi su un cammino puo' essere rosso.

##### Lemma 2
In un albero rosso nero, per ogni nodo $x$: $Nodi(x) \geq 2^{bh(x)}-1$.

##### Dimostrazione
Se $x$ e' **nil** allora $h(x)=-1$ e $bh(x)=0$ quindi $Nodi(x)=0 \geq 2^0 - 1$.
Supposto vero per h-1, per h abbiamo che i figli hanno altezza $y$ $\implies Nodi(y) \geq 2^{bh(x)}-1$ e $z$ $\implies Nodi(z) \geq 2^{bh(z)}-1$, sommando si ottiene la prova.

##### Lemma 3
In un albero rosso nero con n nodi interni e altezza h:
$h \leq 2log(n+1)$.

##### Dimostrazione
$n = Nodi(x) \geq 2^{bh(x)}-1 \geq 2^{\frac{h}{2}}-1 \implies n+1 \geq 2^{\frac{h}{2}} \implies log(n+1) \geq \frac{h}{2} \implies 2log(n+1) \geq h$.

##### Lemma 4
Per ogni albero di altezza $h$, con radice $x$ e figli $y$ e $z$, $bh(y), bh(z) \geq bh(x)-1$

##### Dimostrazione
Se x e' rosso \implies i suoi figli sono neri e quindi entrambi hanno $bh = bh(x)-1$
Se x e' nero allora uno dei suoi figli puo' essere rosso e la sua altezza nera sara' $bh = bh(x)$.

#### Left Leaning Red Black BST
Gli alberi rosso neri orientati a sinistra sono una codifica degli alberi 2-3 che rappresentano i 3-nodi come 2-nodi connessi da un arco rosso. Gli archi rossi sono sempre orientati a sinistra e un nodo non ha mai piu' di 1 arco rosso connesso ad esso e ogni cammino dalla radice a link nullo ha lo stesso numero di link neri.

Operazioni:
- **ricerca**: uguale alla ricerca nei BST
- **inserimento/cancellazione**: uguale all inserimento BST ma si effettuano operazioni locali di rotazioni e color flip per mantenere il bilanciamento.

Confronto con AVL:
Cambia solo la costante, per gli inserimenti numerosi nel caso pessimo sono migliori gli AVL, ma in generale i RBBST sono migliori.

I casi di invalidita' si riducono ai seguenti:
- figlio destro rosso $\implies$ ruota a sinistra
- figlio sinistro rosso, nipote sinistro rosso $\implies$ ruota a destra
- figli entrambi rossi $\implies$ flippa i colori

### B-alberi
Rappresentano un estensione naturale degli alberi 2-3.
Supposto M pari positivo, ogni nodo ospita fino a M-1 coppie chiave-link.
- M viene scelto come il piu grande che consenta di riempire una pagina con M link. 
- La radice ha almeno 2 coppie chiave-link.
- Ogni altro nodo ha almeno $\frac{M}2$ coppie chiave-link
- Separazione dell'indice dai dati:
  - Nodi interni: copie delle chiavi e guidano la ricerca
  - nodi esterni: client keys con riferimenti ai dati.

Definizione:
Un B albero di ordine $M$ e' un k-nodo esterno co k chiavi
oppure un albero con k-nodi interni ognuno con k chiavi e k link a B alberi che rappresentano i k intervalli e k nodi esterni con le proprieta':
- $2 \leq k \leq M-1$ alla radice
- $\frac{M}2 \leq k \leq M-1$ agli altri nodi.

Ogni chiave in un nodo interno e' associata con un altro nodo che e' radice di un albero le cui chiavi sono tutte maggiori o uguali della chiave in questione e minori della chiave successive se presente.

La chiave sentinella e' una particolare chiave minore di tutte le altre utile per i confronti

Un nodo e' full se contiene esattamente $M-1$ chiavi.

La ricerca procede dalla radice fino alle foglie con i vari confronti per ogni link.

Inserimento:
- ricerca della chiave
- se non presente si inserisce in fondo
- risalendo verso la radice, si dividono i nodi con M chiavi.

##### Teorema del bilanciamento dei B alberi
Una ricerca o un inserimento in un B albero di ordine M con N chiavi richiedono un numero di accessi (altezza) compreso tra $log_{M-1}$ e $log_{\frac{M}2}N$

##### Dimostrazione
Segue dal fatto che tutti i nodi interni (tranne la radice) hanno un numero di figli $\frac{M}2 \leq x \leq M-1$. Nel caso peggiore i nodi interni hanno tutti $\frac{M}2$ figli, nel caso migliore hanno tutti $M-1$ figli.

Ottimizzazione: si puo' eliminare un accesso mantenendo la radice nella memoria interna.

##### Proprieta'
- **Complessita' di tempo**: Nel caso peggiore, ad ogni chiamata si scende di livello, il numero di chiamate e' limitato superiormente da $O(\log_{\frac{M}2}N)$.

Se ogni nodo entra in un blocco, il numero di accessi diventa **logaritmico**. Il vantaggio si ha se si sceglie M proporzionale alla dimensione del blocco (nel file system). Su ogni nodo si spende tempo $O(M)$, se le chiavi sono ordinate si puo fare ricerca binaria e quindi $O(\log M)$ per la ricerca $\implies$ $O(\log M \cdot \log_{\frac{M}2}N) = O(\log N)$.

- **Complessita' di spazio**: Nel caso peggiore un B albero usa il doppio dello spazio necessario per le chiavi piu lo spazio per i link; e' dimostrato che il numero medio di chiavi e' circa $M \ln 2$ e lo spazio initilizzato e' mediamente il $44\%$

### Dizionari
Tabelle ad accesso diretto.
Gli array hanno il pregio di avere accesso costante ma le chiavi devono essere interi $\in [0, m-1]$ e lo spazio utilizzato e' proporzionale ad $m$: possibile spreco di memoria.

##### Fattore di carico
Rapporto tra il numero di chiavi utilizzate e la dimensione della tabella. $\frac{N}M$.

### Tabelle Hash
Data una funzione hash $h: U \to [0, m-1]$, un elemento con chiave $k \to v_{h(k)}$.

###### Hashing Perfetto
La funzione hash e' iniettiva.

###### Collisioni
Le collisioni avvengono tra oggetti con chiave diversa ma stesso valore hash.

- Indirizzamento aperto
- Liste di collisione

##### Hash uniforme semplice
La probabilita' che ogni chiave $k$ finisca nella cella $i = 0, ..., m-1$ e' uniforme $Q(i) = \frac{1}m$.

#### Teorema
Sotto l'assunzione di hashing uniforme semplice, la probabilita' che il numero delle chiavi in una lista stia in un intorno di $\frac{N}M$ e' vicina a $1$.

#### Dimostrazione
Se $\alpha = \frac{N}M$ e' il fattore di carico, prese $k$ chiavi tra $N$ ognuna con probabilita' $\frac{1}M$ di essere in una delle liste, le altre $N-k$ hanno probabilita' $1-\frac{1}m$.
La probabilita' che una lista contenga esattamente k chiavi e' la distribuzione binomiale, e per piccoli valori di $\alpha$, approssima una distribuzione di Poisson, che per $k = a$ decade rapidamente.

#### Teorema
Sotto hashing uniforme semplice, una tabella con liste di collisione, una ricerca senza successo richiede tempo medio $\Theta(1+\alpha)$.

#### Dimostrazione
Se l'elemento k non e' inserito allora ogni lista ha la stessa probabilita' $\implies$ teorema precedente.
Altrimenti la complessita' dipende dal numero di elementi gia inseriti nella lista $+ 1$, cioe' $\Theta(1+\alpha)$.

Se $N$ e' proporzionale ad $M$ allora diventa costante.

### Hashing Universale
Consiste nel scegliere la funzione hash in maniera casuale da una classe di funzioni preselezionate. Questo implicherebbe che la lunghezza media di una lista e' al massimo $1+\frac{N}M$.


### Indirizzamento Aperto
Consiste nell'occupare un'altra cella anche se potrebbe spettare ad un'altra chiave.

#### Teorema
Con hashing uniforme semplice, il numero atteso di confronti per una ricerca senza successo e' al piu $\frac{1}{1-a}$.

#### Dimostrazione
Se $X$ v.a. = probe per ricerca, $q_i = P\{X\geq i\}$, il numero atteso di probe e' $\sum_{i=0}^{\infty} q_i$.
La probabilita' di fare almeno 1 probe e' $\alpha$, che l'i-esimo probe trovi una cella occupata dopo che i primi i-1 probe hanno trovato la cella occupata e' $\frac{N N-1 N - 2}{M M-1 M-2}$... $\leq (\frac{N}M)^i = \alpha^i$, e dunque il valore atteso e' maggiorato da $\frac{1}{1-\alpha}$

Per la ricerca con successo, il numero atteso di probe e' $\leq \frac{1}a ln(\frac{1}{1-a})$

### Scansione Lineare o Linear Probing
E' la tecnica di indirizzamento aperta piu' semplice, la ricerca e l'inserimento cercano la cella piu' vicina in maniera contigua per risolvere la collisione a partire dalla cella hash. (probe = confronto tra chiavi)

### Hashing Doppio
Riduce il problema della scansione lineare o quadratica.
In questo caso $h_2(k)$ deve essere coprimo con $M$ perche venga ispezionata tutta la tabella (si sceglie $M$ potenza di $2$ e $h_2$ deve produrre un numero dispari).

### Pattern Matching
Algoritmo di KMP per il riconoscimento di pattern all'interno di stringhe. Si costruisce la matrice del DFA che ha nelle righe l'alfabeto e nelle colonne il pattern (gli stati). Le celle vengono riempite nel seguente modo:
- $\delta(0, 0) = 1$, tutti gli altri caratteri nella prima colonna vanno allo stato $0$.
- si copia il caso di mismatch per tutti i caratteri diversi da quello con cui si ha il match
- nel caso di match si avanza lo stato
- si aggiorna lo stato che tiene traccia dell'alternativa migliore da cui ripartire.

### Sorting di multiset di stringhe
Gli algoritmi di ordinamento generici linearitmici non sono eccellenti per ordinare un insieme di stringhe, perche alla complessita' di tempo si aggiunge un fattore di confronto delle stringhe che e' almeno $O(|lcp(A, B|)$.

#### LCP Array
Supposto $R = \{S_1, ..., S_n\}$ un multiset di stringhe, e assunto $S_1 \leq ... \leq S_n$.
Il Longest Common Prefix Array $LCP[1...n]$ e' definito come segue:
- $LCP_R[1] = 0$
- $LCP_R[2...n] = |lcp(S_i, S_{i-1})|$

#### Teorema sul lower bound
Sia $R = \{S_1, ..., S_n\}$ un insieme di stringhe. Ordinare $R$ in ordine lessicografico mediante un algoritmo basato su confronti di simboli, richiede $\Omega(\Sigma LCP(R) + n\log n)$ confronti.

#### Dimostrazione:
Se le stringhe fossero gia ordinate e si dovrebbe solo confermare l'asserzione allora, per costruzione dell'LCP array, servirebbero almeno $\Omega(LCP(R))$. Per ordinarle servirebbero comunque almeno $\Omega(n \log n)$ confronti usando un algoritmo basato su confronti.


#### 3-Way Quicksort o String Quicksort
Dato in input $R, l$ dove $l = 0$ nella prima chiamata
- Si considera $R_T$ come l'insieme delle stringhe di lunghezza $l$ (non dobbiamo processarle) e si rimuove dall'insieme $R$.
- Scelto un pivot $\in R$
- Si considera $R_<, R_=, R_>$ rispettivamente come gli insiemi che contengono le stringhe $\in R$ confrontando il primo carattere delle stringhe con il primo carattere del pivot.
- Si procede ricorsivamente su questi insiemi con lo stesso $l$ nel caso di disuguaglianza (non c'e' prefisso comune) o $l+1$ altrimenti (c'e' prefisso comune).
- Si concatenano gli insiemi risultanti nell'ordine corretto.

#### Teorema
StringQuicksort ordina un insieme R di n stringhe in $O(\Sigma LCP(R) + n \log n)$ in media. Diventa anche un worst case se si usa una strategia lineare per selezionare il pivot come la mediana di $R$.

#### Dimostrazione
La complessita' di tempo e' dominata dai confronti dei simboli.
Se i simboli sono uguali allora $l$ e' avanzato di $1$ perche c'e' un prefisso comune, possono esserci al piu $\Sigma lcp(R)$ confronti per prefissi in comune.
Se i simboli sono diversi, allora si procede partizionando gli insiemi in $\frac{|R|}2$ ciascuno se la scelta del pivot e' ottimale (per esempio la mediana), ottenendo al piu $O(n\log n)$ confronti ($\log n$ partizioni).

Tale algoritmo evita di riconfrontare prefissi comuni.


#### Radix Sort
E' un algoritmo di ordinamento di stringhe (gli interi sono stringhe di cifre).
- MSD Radix Sort $\implies$ ordina leggendo i caratteri delle stringhe da sinistra verso destra.
- LSD Radix Sort $\implies$ ordina leggendo i caratterei delle stringhe da destra verso sinistra.

##### LSD Radix Sort
- Applica $CoutingSort(R, l)$ per $l = m-1, ..., 0$

Dove il counting sort ordina le stringhe in $R$ in base ai simboli in posizione $l$, la complessita' di tempo e' $O(|R| + \sigma)$ dove $\sigma$ e' la lunghezza dell'alfabeto.

E' un algoritmo stabile.

#### Teorema
LSD Radix Sort ordina un insieme di R stringhe su alfabeto $\sigma$ in $O(||R|| = m\sigma)$ tempo dove $||R||$ e' la lunghezza totale delle stringhe in $R$ e $m$ e' la lunghezza delle stringhe.

#### Dimostrazione
Segue dalla complessita' lineare del counting sort.

##### MSD Radix Sort
Dato un insieme di stringhe $R$ sull alfabeto $[0, ..., \sigma)$
- Se $|R| \lt \sigma$ allora ordina con StringQuicksort, altrimenti
- Considera $R$ tranne le stringhe di lunghezza $l$ (gia processate)
- Applica il counting sort ad $R$ sul carattere $l$-esimo.
- Applica ricorsivamente il MSD Radix Sort sulle stringhe con $l+1$.
- Restituisci la concatenazione delle stringhe rimosse da $R$ inizialmente e delle partizioni.

#### Teorema 
MSD Radix Sort ordina un insieme $R$ di $n$ srtinghe su alfabeto $[0, ..., \sigma)$ in tempo $O(LCP(R) + n \log \sigma)$.

### Trie
Un trie e' un albero radicato in cui ogni nodo ha al piu' $|\Sigma|$ figli, $\Sigma$ alfabeto, dove:
- Ogni arco e' etichettato con un simbolo dell'alfabeto.
- Ogni cammino radice - nodo rappresenta una stringa. I nodi che completano una stringa possono essere marcati o si puo' aggiungere un nodo sentinella per indicare che quel cammino radice nodo rappresenta una stringa..

Il $trie(R)$ e; il piu' piccolo albero che rappresenta un insieme di stringhe $R$.

Il numero di nodi e' dato da $||R||-\Sigma \LCP(R) + 1$ perche i prefissi comuni hanno lo stesso cammino. ($||R||$ somma delle lunghezze delle stringhe).


Per costruirlo e' possibile memorizzare in ogni nodo un array di $\sigma$ caratteri e le foglie contengono le stringhe, quindi $|R| foglie$.

Concatenando i caratteri di un cammino, si produce una stringa (che poi e' la foglia del cammino radice - foglia).


Se l'alfabeto rimane invariato, allora la complessita' di tempo er l'inserimento, la cancellazione e la ricerca di $s$ stringa e' $O(|s|)$. Lo spazio e' $O(||R|| \cdot |\Sigma|)$.

Il numero di nodi di branching e' limitato superiormente da $n$ stringhe, mentre nodi unari (che fanno parte dello stesso prefisso) e' $O(||R||)$.

### Patricia Tree
Variante del trie, per risparmiare spazio, si comprimono i cammini che rappresentano un prefisso comune in un solo arco etichettato con il prefisso comune.

La complessita' di spazio di un compact trie e' $O(|R|)$ oltre alle stringhe.

Ogni nodo interno ha almeno 2 figli, ci sono almeno tante foglie quanto i nodi interni, quindi il numero dei nodi e' al piu' $2|R|$.

Le operazioni di inserimento, cancellazione e ricerca rimangono $O(|s|)$ e le stringhe devono essere memorizzate in $O(||R||)$ separatamente.


### Ternary Search Trie
E' un albero ternario dove ogni nodo ha i seguenti figli:
- **minore**
- **uguale**
- **maggiore**
La posizione $i$ nella stringa cresce nella profondita' ma non in ampiezza.

I Ternary Search Trie sono isomorfi al 3-way quicksort.
Sono alberi di ricerca, e come gli ABR possono essere bilanciati.

Implementano **longest common prefix of** o autocompletamento o **prefix query**.

### Grafi
Se un grafo $G$ ha $V$ vertici e $E$ archi:
- $\sum_{v\in V} deg(v) = 2E$
- Se G non ha archi paralleli ne self loops allora:
  - $E \geq V-1$ se $G$ e' connesso
  - $E = V-1$ se $G$ e' connesso e aciclico (albero)
  - $E \leq V-1$ se $G$ e' una foresta.

Un grafo $G$ e' un albero se avviene una delle seguenti condizioni:
- $G$ ha $V-1$ archi ed e' aciclico
- $G$ ha $V-1$ archi ed e' connesso
- $G$ e' connesso e rimuovendo 1 arco non lo e' piu
- $G$ e' aciclico ma aggiungendo 1 arco non lo e' piu
- $\exists!$ il cammino presa qualunque coppia di vertici.

### Esplorazione di grafi non orientati
#### Teorema sulla DFS
La DFS esegue la marcatura di tutti i vertici connessi ad una sorgente $s$ in tempo proporzionale alla somma dei loro gradi.

#### Dimostrazione
La marcatura assicura che ogni vertice venga visitato una sola volta, e il controllo di marcatura richiede tempo proporzionale al grado.
Se tutti i vertici sono connessi alla sorgente allora il tempo richiesto e' proporizionale a $|E|$.

#### Teorema
Una volta eseguita la DFS, si puo' trovare se esiste un percorso che connette due vertici in tempo proporzionale alla sua lunghezza.

#### Dimostrazione
Un array edgeTo[] tiene traccia dell'albero di esplorazione con radice $s$, un altro array pathTo tiene traccia del percorso dalla sorgente alla destinazione in tempo proporzionale alla lunghezza.

#### Teorema sulla BFS
BFS calcola i shortest path da $src$ a tutti gli altri vertici del grafo in tempo proporzionale a $|E| + |V|$.

#### Dimostrazione
Per un $k \gt 0$ ad un certo passo $k$ ci saranno i vertici di distanza $k$ nella coda, seguiti dai vertici di distanza $k+1$. Ogni vertice entra ed esce dalla coda in ordine rispetto alla loro distanza $k$ perche la marcatura assicura la visita di un vertice 1 volta sola.

#### Proposizione
La DFS in tempo $O(|E| + |V|)$ consente di trovare le componenti connesse di un grafo non orientato. (basta eseguire la DFS su ogni vertice non ancora visitato)

### Esplorazione di grafi orientati
E' noto che in grafo orientato $\sum_{v\in V}indeg(v) = \sum_{v\in V}outdeg(v) = |E|$

#### Teorema sulla DFS per grafi orientati
La DFS esegue la marcatura di tutti i vertici raggiungibili da un dato insieme $S$ di sorgenti in un tempo $O(\sum_{v\in V} outdeg(v))$

#### Dimostrazione
L'algoritmo trova e visita tutti i vertici in un cammino da sorgente a nodo $w$, la marcatura assicura che ogni vertice venga visitato 1 sola volta, quindi il controllo di marcatura e' proporzionale al grado di uscita dei vertici.


### Ordine topologico
E' una sequenza di vertici di un grafo orientato in cui ogni arco ha come vertice di partenza un vertice che precede il vertice di arrivo nella sequenza.

#### Teorema
Un grafo orientato ha un ordine topologico $\iff$ e' un DAG

#### Dimostrazione
Se il grafo ha un ciclo orientato allora non ha un ordine topologico (sorgente ambigua). Se il grafo e' aciclico allora esiste un algoritmo che trova il suo ordine topologico.

#### Ordinamento topologico: Algoritmi
La DFS puo' essere applicata con tre diversi ordini di visita:
- **Preorder**: si inseriscono i vertici in una coda prima della chiamata ricorsiva
- **Postorder**: si inseriscono i vertici in una coda dopo la chiamata ricorsiva
- **Reverse postorder**: si inseriscono i vertici in una pila dopo la chiamata ricorsiva

### Teorema sull ordinamenbto topologico
Il reverse postorder in un DAG e' un ordinamento topologico

### Dimostrazione
Sia dato un arco diretto $(v, w)$, durante la visita DFS:
- $w$ gia visitato $\implies$ return
- $w$ non visitato $\implies$ $dfs(w)$ termina prima di $dfs(v)$
- $w$ gia visitato ma $dfs(v)$ non ancora terminata $\implies$ ciclo $\implies$ G non e' DAG.

Nei primi due casi $dfs(w)$ terminera prima di $dfs(v)$ quindi nella visita in reverse postorder, $v$ precede $w$ nell'ordine.

L'ordinamento topologico e' utile nella rilevazione di cicli.
Puo' essere eseguito in tempo $O(E + V)$.

### Componenti fortemente connesse in un grafo orientato

#### Algoritmo di Kosaraju-Sharir
- Calcola l'ordinamento reverse post order su $G_R$
- Esegui DFS su $G$ visitando i vertici non marcati, seguendo l'ordine topologico del grafo $G_R$.

#### Teorema sulla complessita'
Con l'algoritmo di Kosaraju-Sharir, si calcolano le strong compoent di un grafo in tempo proporzionale a $O(V + E)$.

#### Dimostrazione
Se $C$ e' una componente fortemente connessa di $G$ e $v \not \in C$ e $w \in C | \exists (w, v)$, allora $(w, V)$ e' un back-edge e $v$ e' visitato prima di qualunque altro vertice in $C$.

#### Correttezza
Per induzione, le prime $i$ componenti connesse sono identificate. La componente $i+1$ per la **dfs** visitera' solo vertici non visitati prima (tutti e soli i vertici della componente $i+1$-esima), se visitasse un vertice della $i+2$-esima, allora a cascata visiterebbe anche tutti gli altri e quindi le due componenti connesse sarebbero la stessa.


### Ciclo euleriano in un grafo non orientato
E' un ciclo che contiene tutti gli archi del grafo 1 sola volta.

#### Teorema
Un grafo ha un ciclo euleriano $\iff$ e' connesso e ogni vertice ha grado pari.

#### Dimostrazione
Se esiste un ciclo euleriano allora il grafo e' connesso e vengono visitati tutti i nodi. Inoltre, per ogni arco che si usa per visitare il vertice, ne serve un altro per uscire, quindi il grado e' pari.

Se $G$ e' connesso e ogni vertice ha grado pari allora e' possibile scomporlo nei suoi cicli componenti rimuovendo il primo e procedendo ricorsivamente sulle componenti connesse restanti. Partendo dal ciclo iniziale, ogni volta che si incontra un nodo che e' presente in un altro ciclo, si aggiunge tutto il ciclo, ottenendo alla fine un ciclo euleriano.

#### Osservazione
Per i grafi orientati, si ha un ciclo euleriano orientato $\iff$ $G$ e' connesso e $indegree(v) = outdegree(v), \forall v \in V$.

### Minimum Spanning Tree
Dato un grafo pesato G connesso, un albero ricoprende e' un sottografo T connesso e aciclico che include tutti i vertici di G. Il minimum spanning tree ha somma minima dei pesi.

Se il grafo e' connesso e i pesi sono tutti diversi allora l'MST e' unico.

#### Teorema
Data una qualsiasi partizione del grafo, il crossing edge di peso minimo sta nel MST.

#### Dimostrazione
Se ci fosse un crossing edge di peso minimo al di fuori del MST allora, sostituirlo con il crossing edge che realizza attualmente l'MST, creerebbe un MST di costo inferiore al minimo, il che e' un assurdo.


### Algoritmo di Kruskal
- Si ordinano gli archi in ordine crescente di peso
- Si aggiunge un arco all'albero se cosi facendo non si introduce un ciclo, altrimenti si scarta l'arco.
- Si ripete la 2 fino ad aver inserito $|V|-1$ archi nell'albero.

#### Teorema sulla correttezza
L'algoritmo di Kruskal trova il MST.

#### Dimostrazione
Sia $e$ il crossing edge da inserire per connettere le componenti connesse $v$ e $w$ di costo minimo, allora verra' inserito perche nessun altro crossing edge e' gia stato inserito e nessun crossing edge ha peso minore perche vengono scelti in ordine crescente di peso.


#### Teorema sulla complessita di Kruskal
L'algoritmo trova il MST in tempo (caso peggiore) $O(E \log E)$ e spazio $O(E)$.

#### Dimostrazione
L'ordinamento degli archi prende tempo linearitmico nella quantita' di archi. La Union-Find viene costruita in tempo lineare e interrogazioni vengono fatte in tempo logaritmico. Il ciclo principale itera gli archi ordinati e controlla se appartengono a componenti diverse per un totale di complessita linearitmica nella quantita di archi, l'unione delle componenti prende tempo costante.

### Algoritmo di Prim
- Si parte da un vertice radice e si fa crescere l'albero $T$.
- Si aggiunge all'albero l'arco di minor peso tra quelli che hanno un estremo in $T$ e l'altro estremo in non in $T$.
- Si ripete il passo 2 fino ad avere inserito $|V|-1$ archi a $T$.

#### Teorema sulla correttezza
Prim trova il MST

#### Dimostrazione
Sia $e$ l'arco di peso minimo con un estremo in T e l'altro non in T.
Se T e il taglio, allora nessun crossing edge e' nero e nessun crossing edge ha peso minore di $e$ (perche sono scelti in ordine crescente).


##### Algoritmo di Prim Lazy
Si usa una coda a priorita' per gli archi cross.
Si estrae il minimo dalla coda.
Si scarta se i suoi estremi sono entrambi in gia' in T.
Altrimenti si aggiungono gli archi cross incidenti sull estremo che e' in $T$, si aggiunge $e$ a $T$ e si marca $w$.

#### Teorema sulla complessita'
L’algoritmo di Prim nell’implementazione lazy trova il MST in tempo proporzionale a $O(E \log(E))$ (caso peggiore), con spazio proporzionale a $O(E)$.

#### Dimostrazione
Ogni arco viene inserito e rimosso al massimo una volta, quindi il numero di operazioni sulla coda e' $O(E)$, le operazioni sulla coda richiedono tempo $O(\log E)$, da cui si ha il risultato.

### Shortest Paths
#### Single Source Shortest Paths Tree
Tale albero esiste, se ci sono due cammini dello stesso peso da $s$ a un nodo allora si scarta l'ultimo arco di uno dei due.

Per rappresentare lo Shortest Paths Tree, si usano due array:
- $distTo[v]$ $\implies$ distanza minima dalla sorgente a $v$ (attualmente)
- $edgeTo[v]$ $\implies$ l'ultimo arco del percorso attualmente di minimo costo.

Se durante l'esplorazione del grafo, esiste un arco che passa per un altro nodo e realizza un costo inferiore, allora si aggiornano $distTo$ e $edgeTo$ (rilassamento dell'arco).

#### Teorema sulla condizione di ottimalita' per Shortest Path
$distTo$ contiene le distanze dei Shortest Paths da $s$ $\iff$
- $distTo[s] = 0$
- $distTo[v]$ e' la lunghezza minima da $s \to v, \forall v$
- per ogni arco $e = (v, w)$, $distTo[w] \leq distTo[v] + weight(e)$.

#### Dimostrazione
Se esiste $e = (v, w)$ tale che $distTo[w] \gt distTo[v] + weight(e) \implies \exists$ un cammino da $s$ a $w$ con costo inferiore di quello attuale.

Dato un percorso minimo da $s$ a $w$ e $k$ il suo peso **ottimale**, allora $distTo[w] \leq dist[w-1] + weight((w-1, w))$, ..., e sommando le disuguaglianze si ottiene che $k \leq distTo[w] \leq weight(w_1) + ... + weight(w) \leq k$.


Come scegliere il prossimo arco da considerare nello Shortest Path Tree:
- Dijkstra: pesi non negativi
- Topological sort: DAG
- Bellman-Ford: grafo privo di cicli negativi.


### Algoritmo di Dijkstra
- Si considerano i pesi in ordine crescente di distanza dalla sorgente (all inizio tutti $\infty$ tranne la sorgente $0$).
- Aggiungi il vertice piu vicino ad $s$ e rilassa tutti gli archi che partono da quel vertice.
- Si ripete il secondo passaggio fin che tutti i vertici sono nell'albero o non esistono vertici esterni con valore finito di $distTo$.

#### Teorema 
L'algoritmo di Dijkstra trova uno Shortest Path Tree in un grafo orientato pesato con pesi non negativi

#### Dimostrazione
Ogni arco $(v, w)$ viene rilassato una sola volta mantenendo $distTo[w] \leq distTo[v] + weight((v, w))$. $distTo[w]$ non puo' aumentare e $distTo[v]$ non cambia dato che non ci sono pesi negativi.

La complessita' di tempo dipende dall'implementazione della coda a priorita', utilizzando un heap binario, si ottiene $O(E \log V)$.

#### Dijkstra vs Prim
Entrambi costruiscono l'albero aggiungendo un vertice alla volta. Sono due approcci diversi, Prim realizza una DFS (aggiunge il vertice piu vicino all'albero), Dijkstra una BFS (aggiunge il vertice piu vicino alla sorgente).

#### Grafi diretti pesati aciclici
Esistono algoritmi migliori di dijkstra (anche lineari) in questo caso. (anche con pesi negativi, o per trovare il cammino piu' lungo).

### Topological Sort per Shortest Path Tree
- Si esegue l'ordinamento topologico
- Seguendo l'ordinamento topologico, si prende un vertice e si rilassano gli archi uscenti da quel vertice.

#### Teorema per complessita' e correttezza
L'algoritmo di ordinamento topologico trova uno Shortest Path Tree in qualsiasi grafo diretto pesato aciclico (pesi negativi consentiti) in tempo proporzionale a $O(|E| + |V|)$

#### Dimostrazione
Ogni arco $e = (v, w)$ viene rilassato una volta sola, lasciando $distTo[w] \leq distTo[v] + weight(e)$. La disuguaglianza vale fino alla fine perche' nell'ordine topologico nessun arco che punta a $v$ verra' rilassato dopo che $v$ e' rilassato.

Per trovare il percorso piu' lungo si negano tutti i pesi, si trova il cammino minimo, e si negano i pesi della soluzione.

### Algoritmo di Bellman-Ford
Un algoritmo che consente di trovare uno Shortest Path Tree in presenza di pesi negativi e di cicli (non negativi).

- Inizializza $distTo[s] = 0$ e $distTo[v] = \infty$ per ogni altro vertice
- Ripeti V volte: rilassa tutti gli archi.

Si dimostra che esiste un cammino minimo da $s$ a $v$ in un grago orientato pesato $\iff$ nessun vertice su un cammino da $s$ a $v$ e' su un ciclo negativo.

#### Teorema sulla complessita' e correttezza di Bellman-Ford
L'algoritmo Bellman-Ford trova uno Shortest Path Tree in qualsiasi grafo orientato pesato (pesi negativi, cicli non negativi, non sono consentiti cicli negativi raggiungibili da $s$).

#### Dimostrazione
Sia $v$ il cammino minimo da $s$ a $t$, esiste se non ci sono cicli negativi nel cammino e non puo' avere piu di $V-1$ archi. Per induzione su $i$, all'i-esimo passo si trova il cammino minimo perche al primo passo e' vero, al passo $i$ rilassiamo tutti i vertici compreso $v_i$, cioe' $distTo[v_{i+1}] \leq distTo[v_i] + weight((v_i, v_{i+1}))$. Quindi all'$i$-esima passata si trova il cammino minimo fino a $v_{i+1}$. Da qui si hanno i risultati spazio-temporali.

