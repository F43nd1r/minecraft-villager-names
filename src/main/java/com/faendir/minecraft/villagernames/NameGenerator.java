package com.faendir.minecraft.villagernames;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.regex.Pattern;

public class NameGenerator {
    // Single-syllable pieces
    public static final String[] ONE_SYLLABLE_BEGIN = new String[]{"A", "A", "A", "Ai", "Ba", "Be", "Be", "Bi", "Bi", "Bi", "Bla", "Bo", "Bo", "Bra", "Bra", "Bru", "Bu", "Cai", "Cha", "Che", "Chri", "Chri", "Chri", "Ci", "Ci", "Ci", "Ci", "Ci", "Ci", "Ci", "Ci", "Clou", "Da", "Da", "Dao", "De", "De", "Dji", "Do", "Dua", "E", "Ea", "Ea", "Fa", "Fe", "Fi", "Flo", "Ga", "Gau", "Geo", "Geo", "Geo", "Geo", "Geo", "Geo", "Go", "Guo", "Guy", "Ha", "Hei", "Ho", "Hui", "Hui", "Ja", "Ja", "Ja", "Ja", "Ja", "Ja", "Ja", "Ja", "Ja", "Ja", "Jay", "Ji", "Ji", "Jia", "Jie", "Jo", "Jo", "Joe", "Joe", "Jua", "Ka", "Ka", "Ka", "Kai", "Ki", "Ko", "Kri", "La", "Li", "Li", "Lia", "Lia", "Lo", "Lu", "Lu", "Ma", "Ma", "Ma", "Ma", "Ma", "Mi", "Mi", "Mi", "Na", "Ne", "Ni", "Ni", "No", "Pau", "Pau", "Pe", "Pe", "Pu", "Qia", "Qio", "Rai", "Ray", "Re", "Re", "Ree", "Ree", "Ri", "Ro", "Ru", "Sco", "Sco", "Sco", "Sha", "Sha", "Shu", "Si", "Sji", "Smi", "Smi", "Smy", "Squa", "Tao", "Tha", "Tho", "Ti", "Ti", "To", "To", "To", "Tri", "We", "We", "Wei", "Wei", "Xia", "Xia", "Xu", "Ya", "Ya", "Yo", "Yu", "Ze", "Zhe", "Zo", "Zo", "Zo"};
    /*
     * Villager name pieces
     */
    public static final String[] ONE_SYLLABLE_END = new String[]{"b", "bs", "ce", "ck", "ck", "ck", "ck", "cke", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "de", "dge", "dge", "dge", "ff", "ff", "ff", "ggs", "hd", "hn", "hn", "k", "ke", "ke", "l", "l", "le", "les", "ll", "ll", "ll", "ll", "lm", "m", "m", "m", "m", "m", "m", "mes", "mes", "mes", "mes", "mie", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "ne", "ne", "ne", "ne", "ne", "ne", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "ng", "nh", "nk", "nk", "nn", "nn", "nn", "ps", "r", "rc", "rc", "rc", "rge", "rge", "rge", "rk", "rk", "rl", "rl", "rles", "rn", "rn", "rn", "rth", "rtz", "s", "s", "s", "sch", "sh", "ss", "tch", "tch", "tch", "te", "te", "th", "th", "th", "th", "tt", "tt", "tt", "ve", "x"};
    // Syllable 1 transitional
    public static final String[] SYLLABLE_1_TRANSITION = new String[]{"A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "A", "Aa", "Aad", "Ab", "Ab", "Aer", "Ag", "Ah", "Ai", "Ai", "Al", "Al", "Al", "Al", "Al", "Al", "Al", "Am", "An", "An", "An", "An", "An", "An", "An", "An", "An", "An", "An", "Ar", "Ar", "Ar", "Ar", "As", "Ash", "Ash", "Ay", "Ba", "Ba", "Ba", "Ba", "Ba", "Bai", "Bar", "Bar", "Bar", "Be", "Be", "Ben", "Ben", "Ben", "Beth", "Bez", "Bi", "Bik", "Bil", "Bing", "Bis", "Bo", "Bor", "Bra", "Brad", "Bug", "Byb", "Ca", "Ca", "Ca", "Ca", "Cag", "Cal", "Cal", "Ce", "Ce", "Ce", "Char", "Char", "Chi", "Chia", "Chlo", "Chlo", "Chris", "Chris", "Chry", "Cin", "Cin", "Cin", "Co", "Co", "Con", "Cry", "Cy", "Da", "Da", "Da", "Da", "Da", "Dai", "Dan", "Dar", "Dar", "De", "De", "De", "De", "Dex", "Di", "Di", "Di", "Do", "Do", "Do", "Do", "Do", "Dor", "Dra", "Dun", "Dun", "Dy", "Dy", "Dzog", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "Ed", "Ed", "Ei", "El", "El", "El", "El", "El", "El", "Em", "Em", "Em", "Em", "Em", "Em", "Em", "Em", "En", "Ex", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fa", "Fat", "Fat", "Fen", "Fen", "Fi", "Flo", "Fong", "Fran", "Fran", "Fre", "Fri", "Fu", "Fu", "Fu", "Ga", "Ga", "Ga", "Ga", "Ga", "Ga", "Gab", "Gae", "Gar", "Gar", "Gar", "Geor", "Geor", "Gi", "Gi", "Gil", "Gil", "Gil", "Gior", "Glo", "Go", "Gol", "Gol", "Gor", "Gret", "G\u00fcn", "Gung", "Guts", "Ha", "Ha", "Ha", "Ha", "Ha", "Ha", "Ha", "Ha", "Ha", "Ham", "Han", "Han", "Har", "Har", "Has", "Has", "Has", "He", "Hei", "Hei", "Hel", "Hen", "Hen", "Her", "Hi", "Hi", "Hi", "Hil", "Hil", "Ho", "Ho", "Hos", "Hos", "Hu", "Hus", "I", "I", "I", "I", "I", "I", "I", "I", "If", "If", "In", "In", "Io", "Ir", "Ja", "Ja", "Ja", "Jac", "Jac", "Jack", "Jay", "Jay", "Je", "Je", "Je", "Jen", "Jes", "Jo", "Jo", "Jo", "Jo", "Jo", "John", "John", "Ju", "Ju", "Ju", "Jun", "Ka", "Ka", "Ka", "Ka", "Kef", "Kel", "Ken", "Kha", "Ki", "Ki", "Ki", "Ki", "Klu", "Kok", "Kop", "Krish", "Ksen", "Ku", "La", "La", "La", "La", "Lak", "Lam", "Lau", "Lau", "Lau", "Le", "Le", "Le", "Le", "Le", "L\u00e9", "Lei", "Len", "Lew", "Li", "Li", "Li", "Li", "Lind", "Lo", "Lo", "Lo", "Lou", "Low", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Lu", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Ma", "Maar", "Mah", "Mak", "Man", "Man", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mar", "Mau", "Max", "Me", "Me", "Me", "Meh", "Meh", "Mi", "Mi", "Mi", "Mi", "Mi", "Mi", "Mi", "Mi", "Mi", "Min", "Min", "Min", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mo", "Mon", "Mor", "Mor", "Mu", "Mu", "Mu", "Mu", "Muk", "Myr", "Na", "Na", "Na", "Na", "Na", "Na", "Na", "Ne", "Ne", "Ne", "Nea", "Nel", "Ner", "Ni", "Ni", "Ni", "Ni", "Ni", "No", "No", "No", "No", "No", "No", "No", "No", "No", "Nor", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "Od", "Pa", "Pa", "Pa", "Pal", "Pan", "Pau", "Pe", "Per", "Phae", "Pho", "Pi", "Pi", "Po", "Po", "Pre", "Pri", "Quet", "Quis", "Ra", "Ra", "Ra", "Ra", "Rai", "Rai", "Ras", "Re", "Re", "Re", "Rhi", "Ri", "Ri", "Ri", "Ri", "Ri", "Ro", "Ro", "Ro", "Rob", "Ron", "Row", "Ru", "Ru", "Ru", "Ru", "Ry", "Ry", "Ry", "Sa", "Sa", "Sa", "Sa", "Sa", "Sa", "Sa", "Sad", "Sal", "San", "San", "San", "San", "San", "Sar", "Sar", "Sar", "Scar", "Scar", "Se", "Se", "Se", "Se", "Se", "Sei", "Sel", "Seo", "Sep", "Set", "Sev", "Sha", "She", "Shi", "Shri", "Shu", "Si", "Si", "So", "So", "So", "So", "So", "So", "So", "So", "So", "So", "So", "So", "So", "So", "Sof", "Som", "Sta", "Ste", "Ste", "Stel", "Stra", "Su", "Su", "Syl", "Ta", "Ta", "Ta", "Ta", "Ta", "Tak", "Tal", "Te", "Te", "Te", "Te", "Te", "Tel", "The", "Tho", "Tho", "Tho", "Ti", "Ti", "Ti", "Ti", "Ti", "Ti", "Ti", "Ti", "Tif", "Tif", "Tim", "To", "To", "To", "Tom", "Ton", "Tre", "Tri", "Tsu", "Tsu", "Twin", "U", "Ul", "Un", "Ur", "Va", "Ven", "Vi", "Vi", "Vic", "Vic", "Vik", "Vik", "Vin", "Vin", "Vin", "Wal", "War", "Wen", "Wen", "Wi", "Wil", "Wil", "Wil", "Wil", "Wil", "Wil", "Wil", "Wil", "Wil", "Xan", "Xe", "Xi", "Yas", "Ye", "Yous", "Yu", "Yu", "Yuf", "Zah", "Zan", "Zar", "Ze", "Ze", "Zeb", "Zen", "Zi", "Zig", "Zo", "Zo", "Zur"};
    // Syllable 2 terminal
    public static final String[] SYLLABLE_2_TERMINAL = new String[]{"^Paul", "^Wei", "-fen", "-hao", "-jun", "-yeon", "a", "a", "a", "a", "a", "ah", "ah", "ah", "ah", "ah", "ah", "am", "am", "am", "am", "am", "am", "an", "an", "an", "an", "an", "\u00e3o", "ba", "be", "bert", "bez", "bib", "bolt", "bos", "bul", "by", "by", "ca", "ca", "cal", "can", "can", "card", "cas", "cas", "cas", "ce", "cent", "cent", "chael", "chael", "chai", "chai", "chard", "chel", "chen", "cil", "cious", "cis", "co", "co", "cus", "cus", "cus", "cy", "da", "da", "da", "da", "dam", "dam", "dam", "dane", "de", "death", "deen", "del", "den", "den", "den", "den", "den", "des", "di", "di", "din", "do", "don", "dor", "dra", "dra", "dra", "drei", "drew", "drew", "dy", "dy", "dy", "dy", "dy", "dy", "e", "e", "el", "ell", "erre", "erts", "et", "ex", "ex", "ey", "fa", "fer", "fie", "fus", "ga", "ga", "ga", "gan", "gan", "gann", "gar", "ger", "ghen", "gi", "gi", "go", "go", "go", "gon", "gon", "gret", "gr\u00e9t", "grjet", "guel", "gus", "gy", "ha", "ha", "ha", "ha", "har", "he", "he", "hei", "helm", "ho", "i", "ia", "ia", "id", "iel", "im", "inj", "ior", "is", "is", "is", "ise", "ith", "ja", "jin", "jin", "jo", "jr", "ka", "ka", "ka", "ka", "ka", "kahn", "kain", "kas", "kas", "kau", "ke", "kel", "ki", "ko", "kol", "ku", "kub", "kub", "la", "la", "la", "la", "la", "la", "la", "lah", "lak", "lal", "lal", "lan", "lan", "land", "land", "land", "las", "layne", "led", "len", "lene", "les", "let", "ley", "ley", "li", "li", "li", "li", "liam", "liam", "liam", "liam", "liam", "liam", "lice", "lie", "lie", "lie", "lik", "lim", "lim", "lom", "los", "luf", "ly", "ly", "ly", "lyn", "ma", "ma", "ma", "ma", "ma", "ma", "ma", "ma", "ma", "ma", "ma", "ma", "ma", "mak", "man", "mar", "mar", "marck", "mas", "mas", "mas", "mas", "med", "mer", "met", "mi", "mil", "mon", "m\u00f3n", "moud", "muh", "muh", "mus", "mus", "my", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "naa", "nan", "ne", "nei", "nes", "net", "neth", "ni", "nie", "no", "no", "non", "ny", "ny", "ny", "ny", "o", "o", "o", "o", "on", "on", "ott", "pe", "phie", "qing", "ra", "ra", "ra", "ra", "ra", "rad", "rah", "ram", "rav", "reet", "reh", "rell", "ren", "ren", "rene", "req", "ret", "ric", "rich", "rick", "rid", "rie", "rie", "rik", "rill", "rim", "rin", "rir", "rir", "ris", "ris", "rit", "ro", "ro", "rom", "ron", "ros", "ru", "rus", "ry", "ry", "ry", "ry", "ry", "ry", "ryl", "sa", "sa", "say", "sef", "sef", "sein", "seph", "sey", "sha", "shal", "shmi", "shoi", "sie", "sif", "sil", "sim", "sin", "son", "son", "son", "stal", "sti", "suf", "ta", "tan", "tan", "tar", "tem", "ten", "ter", "ter", "ter", "than", "than", "than", "ther", "tin", "tine", "tis", "to", "ton", "tor", "tos", "trice", "tur", "u", "uel", "va", "va", "va", "val", "van", "ven", "ves", "vey", "vi", "vid", "vin", "vin", "vin", "vine", "vis", "vit", "wa", "ward", "wu", "ya", "ya", "ya", "ya", "ya", "ya", "ya", "ya", "yep", "za", "zat", "ze", "zel", "zer", "zer"};
    // Syllable 2 transitional
    public static final String[] SYLLABLE_2_TRANSITION = new String[]{"a", "a", "a", "a", "a", "a", "a", "a", "a", "an", "an", "bar", "bas", "bas", "bi", "bi", "bi", "bra", "bri", "bri", "bri", "ce", "ces", "chi", "cho", "c\u00ed", "c\u00ed", "cil", "cro", "da", "da", "dal", "de", "de", "de", "deg", "del", "del", "der", "di", "di", "di", "dre", "du", "du", "e", "e", "e", "e", "e", "e", "ex", "ex", "ex", "ex", "fa", "fa", "fal", "fi", "fi", "fi", "fi", "fi", "fi", "fi", "fi", "fi", "fi", "f\u00ed", "f\u00ed", "ga", "ga", "ga", "ga", "ge", "gi", "gi", "gi", "gis", "gu", "gus", "gus", "ha", "ha", "ha", "ha", "ha", "ha", "ham", "ham", "ham", "ham", "ham", "ham", "ham", "ham", "hi", "hi", "i", "i", "i", "i", "i", "i", "i", "i", "ja", "ja", "ka", "ka", "ki", "ko", "ko", "ko", "ku", "la", "le", "le", "le", "le", "lea", "lek", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "li", "lis", "lo", "lo", "lu", "ly", "ma", "ma", "ma", "ma", "ma", "ma", "man", "me", "me", "me", "me", "me", "me", "mi", "mi", "mi", "mi", "mi", "mi", "mi", "mig", "ming", "mir", "my", "na", "na", "na", "na", "naz", "ni", "ni", "no", "no", "nu", "o", "o", "o", "o", "pa", "pan", "pha", "phi", "phi", "phi", "phi", "pu", "qa", "que", "ra", "ra", "ran", "re", "re", "re", "ren", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "ri", "r\u00ed", "r\u00ed", "r\u00ed", "rin", "ro", "ro", "rol", "ru", "ry", "ry", "ry", "sa", "sa", "scil", "se", "se", "so", "so", "sta", "su", "su", "su", "ta", "ta", "ta", "ta", "tas", "te", "te", "te", "te", "the", "tho", "ti", "ti", "ti", "ti", "ti", "ti", "ti", "ti", "ti", "ti", "to", "to", "to", "to", "to", "to", "to", "tou", "tsu", "tsu", "u", "u", "u", "um", "vaa", "ven", "vi", "ya", "zal", "ze", "zul"};
    // Syllable 3 terminal
    public static final String[] SYLLABLE_3_TERMINAL = new String[]{"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "am", "am", "am", "am", "am", "an", "as", "as", "ba", "ba", "bar", "bert", "ca", "ca", "ca", "chi", "co", "da", "da", "da", "den", "dor", "dou", "el", "el", "elle", "fa", "garde", "ger", "go", "hill", "him", "id", "in", "ja", "ja", "ja", "ka", "ka", "ki", "ki", "ko", "la", "la", "la", "la", "la", "la", "la", "lah", "lah", "lat", "lene", "lin", "line", "lite", "lon", "lon", "los", "ly", "ly", "lyn", "lyn", "ma", "ma", "ma", "ma", "ma", "ma", "ma", "maa", "mad", "mad", "mad", "mad", "mad", "mad", "mad", "mar", "mat", "med", "med", "med", "med", "med", "med", "meh", "meh", "mesh", "mesh", "mesh", "meth", "mi", "min", "min", "mon", "mos", "mut", "my", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "na", "nath", "ne", "ne", "nel", "nic", "nie", "no", "no", "non", "nor", "noush", "ny", "ny", "ny", "o", "o", "o", "o", "on", "os", "pa", "pher", "pher", "pu", "ra", "ra", "ra", "ra", "ra", "rant", "rat", "re", "re", "rey", "rin", "roth", "roth", "sa", "sa", "sha", "sine", "son", "son", "syl", "ta", "thy", "t\u00edn", "t\u00edn", "to", "to", "trix", "us", "va", "va", "va", "va", "ver", "ver", "ver", "ver", "ver", "way", "ya", "ya", "ya", "ya", "ya", "yah", "zo"};
    // Syllable 3 transitional
    public static final String[] SYLLABLE_3_TRANSITION = new String[]{"-A", "-Rah", "a", "a", "a", "a", "a", "a", "a", "a", "a", "an", "an", "an", "an", "baa", "bel", "bel", "can", "car", "ci", "c\u00f3", "do", "fis", "ga", "i", "i", "i", "ic", "li", "li", "li", "li", "li", "li", "lo", "lu", "ma", "me", "na", "ni", "ni", "no", "pho", "pho", "ri", "ri", "ri", "ri", "san", "sta", "ti", "ti", "to", "tro", "u", "vi", "vi", "vi", "vi", "vi", "vi", "vi", "za"};
    // Syllable 4 terminal
    public static final String[] SYLLABLE_4_TERMINAL = new String[]{"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "\u00e1n", "\u00e1n", "be", "beth", "cia", "cia", "dar", "der", "der", "der", "der", "go", "go", "go", "go", "ja", "la", "la", "la", "li", "ma", "man", "mi", "mu", "na", "na", "na", "ne", "nin", "o", "on", "phe", "ra", "rii", "sia", "ta", "tar", "te"};
    // Syllable 4 transitional
    public static final String[] SYLLABLE_4_TRANSITION = new String[]{"^Car", "a", "gi", "nas", "o", "te"};
    // Syllable 5 terminal
    public static final String[] SYLLABLE_5_TERMINAL = new String[]{"a", "men", "ne", "ri", "sus", "tl"};
    private static final Logger LOGGER = LogManager.getLogger();

    public static String generateName() {

        Random random = new Random(); // Overwrites world random because of simultaneity issues

        // The piece of interest
        String rootName = "";

        // These integers will get iterated over every time a root generation fails.
        // An exception is thrown if one gets to 50--pretty generous, if I say so.
        // Someone has to have REALLY bungled up syllable pools to have done this.
        int tooManyFailures = 50;
        int blankRoot = 0;
        int sizeOverflow = 0;
        int sizeUnderflow = 0;
        int repeatedChar = 0;
        int filterFail = 0;

        int r; // Integer used for randomizing

        // The while loop continues until a valid name is generated or an exception is thrown
        while (true) {

            // Step 1: Determine whether or not this will be a one-syllable name
            r = random.nextInt(ONE_SYLLABLE_BEGIN.length + SYLLABLE_1_TRANSITION.length);
            if (r < ONE_SYLLABLE_BEGIN.length) { // This will be a monosyllabic name.
                rootName = ONE_SYLLABLE_BEGIN[r];
                // Now try to generate an end cap
                r = random.nextInt(ONE_SYLLABLE_BEGIN.length);
                if (r < ONE_SYLLABLE_END.length) { // Add an ending part to the syllable
                    rootName += ONE_SYLLABLE_END[r];
                }

                // The root name was created. It is one syllable long.
            } else { // This will be a polysyllabic name.
                // Start with a 1-syl transitional name
                rootName = SYLLABLE_1_TRANSITION[r - ONE_SYLLABLE_BEGIN.length];

                // Step 2: Determine whether to stop at syllable 2 or continue to a third
                r = random.nextInt(SYLLABLE_2_TERMINAL.length + SYLLABLE_2_TRANSITION.length);
                if (r < SYLLABLE_2_TERMINAL.length) { // This name will terminate at syllable 2.
                    rootName += SYLLABLE_2_TERMINAL[r];
                } else { // This name will go on to a third syllable.
                    rootName += SYLLABLE_2_TRANSITION[r - SYLLABLE_2_TERMINAL.length];

                    // Step 3: Determine whether to stop at syllable 3 or continue to a fourth
                    r = random.nextInt(SYLLABLE_3_TERMINAL.length + SYLLABLE_3_TRANSITION.length);
                    if (r < SYLLABLE_3_TERMINAL.length) { // This name will terminate at syllable 3.
                        rootName += SYLLABLE_3_TERMINAL[r];
                    } else { // This name will go on to a fourth syllable.
                        rootName += SYLLABLE_3_TRANSITION[r - SYLLABLE_3_TERMINAL.length];

                        // Step 4: Determine whether to stop at syllable 4 or continue to a fifth
                        r = random.nextInt(SYLLABLE_4_TERMINAL.length + SYLLABLE_4_TRANSITION.length);
                        if (r < SYLLABLE_4_TERMINAL.length) { // This name will terminate at syllable 4.
                            rootName += SYLLABLE_4_TERMINAL[r];
                        } else { // This name will go on to a fifth syllable.
                            rootName += SYLLABLE_4_TRANSITION[r - SYLLABLE_4_TERMINAL.length];

                            // Step 5: Determine whether to stop at syllable 5 or continue to a sixth
                            r = random.nextInt(SYLLABLE_5_TERMINAL.length);
                            // This name will terminate at syllable 5.
                            rootName += SYLLABLE_5_TERMINAL[r];
                        }
                    }
                }
            }

            // Step 2V: clean up for validation

            rootName = rootName.trim();

            // Replace carets here with INTENTIONAL spaces.
            rootName = rootName.replaceAll("\\^", " ");

            // I have to reject this (root) name if it's not within the allotted size threshold.
            // Also I should ensure the last three characters are not all the same.

            if (rootName.length() > 15) { // Root name is too long.
                sizeOverflow++;
            } else if (rootName.length() >= 3) {
                // Now, make sure the same characters don't appear in the name three times in a row
                if (Pattern.matches("(.)\\1{2}", rootName.toLowerCase())) {
                    repeatedChar++; // Detected three of the same letter in a row.
                } else {
                    // Do a content scan
                    if (!contentScan(rootName)) {
                        // Passes all the checks! Accept the name!
                        break;
                    }
                    // Something caught the attention of the filter
                    filterFail++;
                }
            } else if (rootName.length() == 2 && rootName.toLowerCase().charAt(0) != rootName.toLowerCase().charAt(1)) {// Now ensure that a two-letter name isn't the same letter twice.
                    // Passes all the checks! Accept the name!
                    break;
            } else if (rootName.length() > 0) {
                sizeUnderflow++; // Root name is too short.
            } else blankRoot++; // Root name is blank.

            // Step 2X
            // If we counted too many invalid name attempts, throw an exception
            if (sizeOverflow >= tooManyFailures) {
                String errorMessage = "Villager names are too long! Check your syllable lengths.";
                LOGGER.fatal(errorMessage);
                throw new RuntimeException(errorMessage);
                //r_prefix = rootName = r_suffix = "";
                //break;
            }
            if (sizeUnderflow >= tooManyFailures) {
                String errorMessage = "Villager names are too short! Check your syllables configs.";
                LOGGER.fatal(errorMessage);
                throw new RuntimeException(errorMessage);
                //r_prefix = rootName = r_suffix = "";
                //break;
            }
            if (blankRoot >= tooManyFailures) {
                String errorMessage = "Villager Produced blank names! Check your syllable configs.";
                LOGGER.fatal(errorMessage);
                throw new RuntimeException(errorMessage);
                //r_prefix = rootName = r_suffix = "";
                //break;
            }
            if (repeatedChar >= tooManyFailures) {
                String errorMessage = "Villager has too many consecutive repeated letters! Check your syllable configs.";
                LOGGER.fatal(errorMessage);
                throw new RuntimeException(errorMessage);
                //r_prefix = rootName = r_suffix = "";
                //break;
            }
            if (filterFail >= tooManyFailures) {
                String errorMessage = "Villager has tripped the content filter too many times. Are you being naughty?";
                LOGGER.fatal(errorMessage);
                throw new RuntimeException(errorMessage);
                //r_prefix = rootName = r_suffix = "";
                //break;
            }
        }

        return rootName;
    }


    /**
     * Scans the input string and returns "true" if there is a particular series
     * of sub-strings within.
     */
    private static boolean contentScan(String inputString) {

        // Updated in v3.1trades
        String[] filterList = new String[]{
                //"avyngf", // Russian guy - left in because there is a stronghold with that name
                //"erygvu", // Austrian guy - left in because Russian guy was left in
                "erttva", // Black
                "gbttns", // Sticks
                "upgvo", // Lady dog
                "gahp", // Lady place
                "zvhd", // Inventive Nordic lady place
                "xphs", // F
                "gvuf", // Dook
                "laans", // A belt pack that you wear
                "mncf", // Mario Party 8 Oopsie
                "lffhc", // Weakling
                "rxvx", // K
                "rybuffn", // Exit hole
                "fvarc", // Protrusion and exit hole
                "navtni", // Inset exit hole
                "eranro", // Southern companion
                //"rcne", // Snuggle - left in because some names have that string
                "ghyf", // Loves to love
                "rebuj", // Loves to love
                "vngaru", // H toon
        };

        for (String s : filterList) {
            if ((inputString).toLowerCase().contains(new StringBuilder(rot13(s)).reverse().toString())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Rot13 codec
     * Adapted from: http://introcs.cs.princeton.edu/java/31datatype/Rot13.java.html
     */
    public static String rot13(String s) {

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;

            out.append(c);
        }
        return out.toString();
    }


}
