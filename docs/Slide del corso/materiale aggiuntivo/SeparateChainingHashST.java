import java.util.*;

/**
 * SeparateChainingHashST con:
 * - chiavi generiche K e valori V
 * - gestione di due funzioni hash (power of two choices): si inserisce nella
 * lista più corta
 * - metodo putDupl per inserire chiavi duplicate
 * - strumenti per contare le liste vuote e le comparazioni
 *
 * Complessità (tabella con fattore di carico α = N/M):
 * - hash1 / hash2: O(1)
 * - get: O(1 + α) medio, O(N) peggiore
 * - put: O(1 + min(α1, α2)) medio con due hash, O(N) peggiore
 * - putDupl: O(1) medio se si inserisce in testa; O(N) peggiore solo in caso di
 * catene patologiche
 * - countEmptyChains: O(M)
 *
 * Nota didattica:
 * Questo file è pensato per l'esercizio e contiene anche un main di test.
 */
public class SeparateChainingHashST<K, V> {

    private static final int DEFAULT_M = 4;

    /** Nodo di lista concatenata. */
    private static class Node<K, V> {
        K key;
        V val;
        Node<K, V> next;

        Node(K key, V val, Node<K, V> next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /** Lista concatenata semplice per ogni bucket. */
    private static class SequentialSearchST<K, V> {
        private Node<K, V> first;
        private int size;

        int size() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }

        /**
         * Restituisce il valore associato alla chiave.
         * Complessità: O(lunghezza lista)
         */
        V get(K key) {
            for (Node<K, V> x = first; x != null; x = x.next) {
                if (x.key.equals(key)) {
                    return x.val;
                }
            }
            return null;
        }

        /**
         * Inserisce o aggiorna una chiave.
         * Se la chiave esiste già, aggiorna il valore.
         * Complessità: O(lunghezza lista)
         */
        void put(K key, V val) {
            for (Node<K, V> x = first; x != null; x = x.next) {
                if (x.key.equals(key)) {
                    x.val = val;
                    return;
                }
            }
            first = new Node<>(key, val, first);
            size++;
        }

        /**
         * Inserisce sempre un nuovo nodo, anche se la chiave esiste già.
         * Usato per il metodo putDupl.
         * Complessità: O(1)
         */
        void putDupl(K key, V val) {
            first = new Node<>(key, val, first);
            size++;
        }

        /**
         * Ritorna il numero di confronti necessari per cercare una chiave.
         * È utile per misurare i confronti dell'inserimento.
         */
        int comparisonsForKey(K key) {
            int cmp = 0;
            for (Node<K, V> x = first; x != null; x = x.next) {
                cmp++;
                if (x.key.equals(key)) {
                    return cmp;
                }
            }
            return cmp;
        }
    }

    private int M; // numero di liste/bucket
    private int N; // numero di elementi presenti
    private SequentialSearchST<K, V>[] chains;

    // Contatore di confronti effettuati nell'ultima put (utile per il plot)
    private int lastComparisons;

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST() {
        this(DEFAULT_M);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashST(int M) {
        if (M <= 0) {
            throw new IllegalArgumentException("M deve essere > 0");
        }
        this.M = M;
        this.N = 0;
        this.chains = (SequentialSearchST<K, V>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            chains[i] = new SequentialSearchST<>();
        }
    }

    /** Prima funzione hash. */
    private int hash1(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /** Seconda funzione hash. */
    private int hash2(K key) {
        int h = key.hashCode() * 31 + 17;
        return (h & 0x7fffffff) % M;
    }

    /**
     * Inserimento standard: usa la più corta tra le due liste candidate.
     * Se la chiave esiste nella lista scelta, aggiorna il valore.
     * Complessità media: O(1 + min(α1, α2)).
     */
    public void put(K key, V val) {
        int i1 = hash1(key);
        int i2 = hash2(key);

        int len1 = chains[i1].size();
        int len2 = chains[i2].size();

        int chosen = (len1 <= len2) ? i1 : i2;

        // Contiamo i confronti effettivamente necessari nella lista scelta.
        // La ricerca è fatta nella lista scelta, e l'inserimento avviene lì.
        lastComparisons = chains[chosen].comparisonsForKey(key);
        if (chains[chosen].get(key) == null) {
            chains[chosen].put(key, val);
            N++;
        } else {
            chains[chosen].put(key, val);
        }
    }

    /**
     * Inserisce la chiave senza sostituire eventuali occorrenze precedenti.
     * Utile quando si vogliono ammettere duplicati.
     * Complessità: O(1) medio, perché inserisce in testa.
     */
    public void putDupl(K key, V val) {
        int i1 = hash1(key);
        int i2 = hash2(key);
        int len1 = chains[i1].size();
        int len2 = chains[i2].size();
        int chosen = (len1 <= len2) ? i1 : i2;
        chains[chosen].putDupl(key, val);
        N++;
        lastComparisons = 0;
    }

    /** Restituisce il valore associato a key. */
    public V get(K key) {
        int i1 = hash1(key);
        int i2 = hash2(key);

        // Per coerenza con la strategia di inserimento, cerchiamo nella più corta.
        int chosen = (chains[i1].size() <= chains[i2].size()) ? i1 : i2;
        return chains[chosen].get(key);
    }

    public int size() {
        return N;
    }

    public int buckets() {
        return M;
    }

    public int lastComparisons() {
        return lastComparisons;
    }

    /**
     * Conta quante liste sono vuote.
     * Complessità: O(M)
     */
    public int countEmptyChains() {
        int empty = 0;
        for (SequentialSearchST<K, V> chain : chains) {
            if (chain.isEmpty()) {
                empty++;
            }
        }
        return empty;
    }

    /** Restituisce la lunghezza delle liste, utile per debugging. */
    public int[] chainLengths() {
        int[] lens = new int[M];
        for (int i = 0; i < M; i++) {
            lens[i] = chains[i].size();
        }
        return lens;
    }

    // ------------------------------------------------------------
    // Sezione di test / traccia richiesta dall'esercizio
    // ------------------------------------------------------------

    /**
     * Genera N interi casuali distinti.
     * Questo evita che duplicati riducano il numero di inserimenti reali.
     */
    public static int[] randomDistinctInts(int N, long seed) {
        Random rnd = new Random(seed);
        Set<Integer> set = new HashSet<>();
        while (set.size() < N) {
            set.add(rnd.nextInt());
        }
        int[] a = new int[N];
        int i = 0;
        for (Integer x : set) {
            a[i++] = x;
        }
        return a;
    }

    /**
     * Stampa la traccia dell'inserimento delle lettere EASYQUTION
     * con M = 3, h1 = 11k mod M e h2 = 17k mod M.
     *
     * Nota: per M = 3, 11 mod 3 = 17 mod 3 = 2, quindi le due funzioni
     * hash coincidono. La scelta della lista più corta non cambia il bucket.
     */
    public static void traceEasyQuestionLikeInsertion() {
        String word = "EASYQUTION"; // 10 lettere
        int M = 3;
        int[] buckets = new int[M];
        int[] sizes = new int[M];

        System.out.println("\nTraccia inserimento EASYQUTION con M = 3");
        System.out.println(
                "k = posizione nella parola, lettera, h1 = 11k mod 3, h2 = 17k mod 3, scelgo la lista più corta");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-3s %-4s %-8s %-8s %-10s%n", "k", "ch", "h1", "h2", "bucket scelto");

        for (int idx = 0; idx < word.length(); idx++) {
            char ch = word.charAt(idx);
            int k = alphabetIndex(ch); // A=1, B=2, ..., Z=26
            int h1 = (11 * k) % M;
            int h2 = (17 * k) % M;

            // se uguali, il bucket è lo stesso; in generale scegliamo la lista più corta
            int chosen;
            if (sizes[h1] < sizes[h2]) {
                chosen = h1;
            } else if (sizes[h2] < sizes[h1]) {
                chosen = h2;
            } else {
                chosen = h1; // pareggio: scelgo h1
            }

            sizes[chosen]++;
            buckets[chosen]++;
            System.out.printf("%-3d %-4s %-8d %-8d %-10d%n", k, ch, h1, h2, chosen);
        }

        System.out.println("Bucket finali: [" + buckets[0] + ", " + buckets[1] + ", " + buckets[2] + "]");
        System.out.println("Liste vuote finali: " + countZeros(buckets));
        System.out.println(
                "Osservazione: con M = 3 le due hash coincidono sempre, quindi la doppia hash non migliora questa specifica traccia.");
    }

    private static int countZeros(int[] a) {
        int z = 0;
        for (int x : a)
            if (x == 0)
                z++;
        return z;
    }

    private static int alphabetIndex(char c) {
        if (c < 'A' || c > 'Z') {
            throw new IllegalArgumentException("La lettera deve essere maiuscola A-Z: " + c);
        }
        return c - 'A' + 1;
    }

    /**
     * Esperimento: N = 10, 10^2, 10^3, 10^4, 10^5, 10^6.
     * Per ogni N si costruisce una tabella con M = N / 2 (almeno 1)
     * e si conta quante liste risultano vuote dopo gli inserimenti.
     *
     * La scelta di M può essere adattata alla consegna del docente.
     */
    public static void experimentEmptyLists() {
        int[] Ns = { 10, 100, 1_000, 10_000, 100_000, 1_000_000 };
        long seed = 123456789L;

        System.out.println("\nEsperimento liste vuote (tabella dinamica con M = N/2)");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s %-10s %-14s %-14s%n", "N", "M", "empty_lists", "load_factor");

        for (int N : Ns) {
            int M = Math.max(1, N / 2);
            SeparateChainingHashST<Integer, Integer> st = new SeparateChainingHashST<>(M);
            int[] keys = randomDistinctInts(N, seed + N);
            for (int key : keys) {
                st.put(key, key);
            }
            int empty = st.countEmptyChains();
            double alpha = (double) st.size() / st.buckets();
            System.out.printf("%-10d %-10d %-14d %-14.4f%n", N, M, empty, alpha);
        }

        System.out.println();
        System.out.println("Se vuoi un valore teorico atteso per il numero di liste vuote, puoi usare:");
        System.out.println("E[vuote] ≈ M * (1 - 1/M)^N");
    }

    /**
     * Esperimento N = 100 su chiavi maiuscole casuali.
     * Stampa il numero di confronti di ogni inserimento: questi dati possono essere
     * copiati in un file CSV e plottati con Python/Excel.
     */
    public static void experimentComparisonsUppercase() {
        int N = 100;
        int M = 31; // dimensione ragionevole per il test
        Random rnd = new Random(20260401L);
        SeparateChainingHashST<Character, Integer> st = new SeparateChainingHashST<>(M);

        List<Integer> comparisons = new ArrayList<>();

        System.out.println("\nEsperimento confronti per N = 100 chiavi maiuscole");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-5s %-12s%n", "i", "key", "confronti");

        for (int i = 1; i <= N; i++) {
            char key = (char) ('A' + rnd.nextInt(26));
            st.putDupl(key, i); // con duplicazione, ogni inserimento viene contato davvero
            comparisons.add(st.lastComparisons());
            System.out.printf("%-5d %-5s %-12d%n", i, key, st.lastComparisons());
        }

        System.out.println("\nCSV (indice,confronti):");
        for (int i = 0; i < comparisons.size(); i++) {
            System.out.println((i + 1) + "," + comparisons.get(i));
        }
        System.out.println("\nQuesti dati possono essere plottati con un grafico a linee o a punti.");
    }

    public static void main(String[] args) {
        // 1) traccia richiesta per EASYQUTION
        traceEasyQuestionLikeInsertion();

        // 2) numero di liste vuote per N = 10 ... 10^6
        experimentEmptyLists();

        // 3) N = 100 chiavi maiuscole e confronti per ogni inserimento
        experimentComparisonsUppercase();
    }
}
