-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 05 Νοε 2017 στις 19:15:42
-- Έκδοση διακομιστή: 10.1.21-MariaDB
-- Έκδοση PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `appcook`
--

DELIMITER $$
--
-- Διαδικασίες
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getsimpleuser` ()  begin

SELECT *
FROM ((((User
INNER JOIN U_S ON User.uemail= U_S.uemail and User.uemail= 'simple@user.com')
INNER JOIN SubCategory ON U_S.subid= SubCategory.subid)
INNER JOIN S_R ON SubCategory.subid= S_R.subid)
INNER JOIN Recipe ON S_R.rid= Recipe.rid)
ORDER BY SubCategory.subid;

end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `authenticuser`
--

CREATE TABLE `authenticuser` (
  `email` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `fname` varchar(40) DEFAULT NULL,
  `lname` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `authenticuser`
--

INSERT INTO `authenticuser` (`email`, `password`, `fname`, `lname`) VALUES
('eua@mariou.com', 'marios123', 'eua', 'pap'),
('marios@gol.com', 'iii@@@', 'mar', 'gol');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `a_f`
--

CREATE TABLE `a_f` (
  `email` varchar(40) NOT NULL,
  `qid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `faqs`
--

CREATE TABLE `faqs` (
  `qid` int(11) NOT NULL,
  `qtitle` varchar(40) DEFAULT NULL,
  `qanswer` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `favorite`
--

CREATE TABLE `favorite` (
  `email` varchar(40) NOT NULL,
  `rid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `recipe`
--

CREATE TABLE `recipe` (
  `rid` int(11) NOT NULL,
  `rtitle` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `rimpath` varchar(128) DEFAULT NULL,
  `mdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `steps` varchar(600) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `recipe`
--

INSERT INTO `recipe` (`rid`, `rtitle`, `rimpath`, `mdesc`, `steps`) VALUES
(0, 'tpt', '', '', ''),
(1, 'Γεμιστά ρολάκια κιμά', 'http://192.168.1.3:8081/orektika/MeKreatika/rolakiaKima', '1. 1 κιλό κιμά (ανάμικτο μοσχαρίσιο και χοιρινό)\n2. 1 μεγάλο κρεμμύδι\n3. 3 σκελίδες σκόρδο λειωμένο\n4. 1 ματσάκι μαϊντανό\n5. 2 αυγά\n6. 2 φρυγανιές\n7. 1 1/2 κουταλάκι αλάτι\n8. Πιπέρι\n9. 80 ml άσπρο κρασί\n10. 2 αυγά για το πανάρισμα\n11. τυρί ρεγκάτο ή γραβι', '1.	Τρίβουμε τα παξιμαδάκια χτυπάμε το κρεμμύδι με το μαϊντανό και τα αυγά και ανακατεύουμε καλά όλα τα υλικά μαζί.\n2.	Κόβουμε το τυρί σε μπαστουνάκια.\n3.	Κόβουμε το ζαμπόν σε λωρίδες.\n4.	Χτυπάμε σε μπολ τα αυγά με νερό για το πανάρισμα.\n5.	Χτυπάμε τα '),
(2, 'Κοτομπουκιές πανέ στο φούρνο', 'http://192.168.1.3:8081/orektika/MeKreatika/Kotompoukies', '<ul>\n <li>700 γρ. κοτόπουλο στήθος φιλέτο</li>\n <li>70 γρ. γαλέτα</li>\n <li>70 γρ. παρμεζάνα</li>\n <li>1/2 φλιτζάνι ελαιόλαδο</li>\n <li>το χυμό ενός λεμονιού</li>\n <li>1 κ.γ. μουστάρδα</li>\n <li>αλάτι</li>\n <li>πιπέρι φρεσκοτριμμένο</li>\n</ul>', '<ol>\n<li>Κόβουμε το φιλέτο σε μπουκιές.</li>\n<li>Σε ένα μπολ βάζουμε το λάδι, το λεμόνι, την μουστάρδα, το αλάτι και τέλος το πιπέρι και χτυπάμε να ομογενοποιηθεί το μείγμα.</li>\n<li>Σε ένα άλλο μπολ βάζουμε την γαλέτα με την παρμεζάνα.</li>\n<li>Βουτάμε τις μπουκίτσες στο λαδολέμονο και μετά στο μείγμα γαλέτας-παρμεζάνας.</li>\n<li>Βάζουμε στο ταψί μας λαδόκολλα και τοποθετούμε τις κοτομπουκιές την μία δίπλα στην άλλη χωρίς να ακουμπάνε.</li>\n<li>Βάζω σε προθερμασμένο φούρνο στους 180ο θερμό αέρα στην 2η θέση από κάτω και ψήνω για 20 λεπτά.</li>\n</ol>'),
(6, 'Muffins με κολοκυθάκια', 'http://192.168.1.3:8081/orektika/MeLaxanika/muffinsMeKolokith', '<ul>\n <li>2 - 3 κολοκυθάκια τριμμένα</li>\n <li>150 γρ. γιαούρτι στραγγιστό</li>\n <li>2 αυγά χτυπημένα</li>\n <li>1/2 ποτήρι καλαμποκέλαιο</li>\n <li>1 ποτήρι αλεύρι που φουσκώνει μόνο του</li>\n <li>150 γρ. φέτα τριμμένη</li>\n <li>αλάτι</li>\n <li>1-2', '<ol>\n<li>Αναμιγνύουμε όλα τα υλικά μαζί και κάνουμε ένα πηχτό χυλό.</li>\n<li>Λαδώνουμε καλά τις υποδοχές για τα muffins (ταψάκια για muffins) ή τα χαρτάκια για muffins και πασπαλίζουμε με φρυγανιά.</li>\n<li>Ρίχνουμε στις υποδοχές 2 - 3 κουταλιές απo το μείγμα και τα ψήνουμε στους 180 βαθμούς μέχρι να ροδίσει όλη τους η επιφάνεια (περίπου 50 λεπτά ανάλογα το φούρνο).</li>\n</ol>'),
(7, 'Γεμιστό Αβοκάντο', 'http://192.168.1.3:8081/orektika/MeLaxanika/gemistoAvokanto', '<ul>\n <li>1 Αβοκάντο</li>\n <li>1 Ντομάτα</li>\n <li>1 Αγγουράκι</li>\n <li>1 Κούπα γιαουρτι</li>\n <li>1 Κουτάλι σούπας ψιλοκομμένο φρέσκο κρεμμύδι</li>\n <li>Φρέσκο μαϊντανό ψιλοκομμένο για γαρνίρισμα</li>\n <li>Μια πρεζα αλάτι</li>\n</ul>', '<ol>\n<li> Κόβουμε το Αβοκάντο στη μέση και με ενα κουτάλι αφαιρούμε προσεκτικά τη σάρκα.</li>\n<li>Σε μπώλ βαζουμε τη ντομάτα και το αγγουράκι, αφού τα έχουμε ψιλοκόψει.</li>\n<li>Προσθέτουμε την σάρκα του αβοκάντο, το φρέσκο κρεμμυδάκι και το γιαουρτι.</li>\n<li>Αλατίζουμε και ανακατεύουμε.</li>\n<li>Με ενα κουτάλι γεμίζουμε τα μισά του αβοκάντο, πασπαλίζουμε με ψιλοκομμένο μαϊντανό και σερβίρουμε.</li>\n</ol>'),
(11, 'Γαρίδες λεμονάτες με πιπεριές', 'http://192.168.1.3:8081/orektika/MeThalassina/garidesMePiperies', '<ul>\n <li>500 γρ γαρίδες μεσαίες</li>\n <li>100 γρ νερό ζεστό</li>\n <li>1 συμπυκνωμένος ζωμός λαχανικών</li>\n <li>100 γρ ελαιόλαδο</li>\n <li>3 σκελίδες σκόρδο σε φέτες</li>\n <li>30 γρ χυμός λεμονιού</li>\n <li>2 κουτ σούπας μαϊντανός ψιλοκομμένος</li', '<ol>\n<li> Ξεπλένουμε καλά τις γαρίδες και τις αφήνουμε να στραγγίξουν σε τρυπητό σκεύος.</li>\n<li>Σε ένα μπλέντερ αναμιγνύουμε το νερό, τον ζωμό και το ελαιόλαδο μέχρι να διαλυθεί ο ζωμός..</li>\n<li>Ρίχνουμε το μίγμα σε ένα βαθύ τηγάνι και προσθέτουμε το σκόρδο, το χυμό λεμονιού, το μαϊντανό και τις πιπεριές.</li>\n<li>Βράζουμε για 2 λεπτά περίπου και κατόπιν προσθέτουμε τις γαρίδες, αλατίζοντάς τες ελαφρά.</li>\n<li>Τέλος, προσθέτουμε τη μουστάρδα και αφήνουμε να βράσει για ακόμα 3 λεπτά περίπου, ανακατεύοντας με απαλές κινήσεις.</li>\n<li>Αποσύρουμε από την φωτιά και σερβίρουμε αμέσως.</l'),
(12, 'Καναπεδάκια με μους σολομού', 'http://192.168.1.3:8081/orektika/MeThalassina/kanapedakiaSolomou', '<ul>\n <li>100 γρ. καπνιστό σολομό</li>\n <li>100 γρ. τυρί κρέμα</li>\n <li>1 κ.γ. μαγιονέζα</li>\n <li>άνηθο όσο θέλετε</li>\n <li>λιγο λεμόνι</li>\n <li>φρυγανισμένο ψωμί του τοστ σε τέταρτα</li>\n</ul>', '<ol>\n<li> Πολτοποιείτε όλα τα υλικά - πλην του ψωμιού - σε μούλτι.</li>\n<li>Αλείφετε το ψωμί και αν θέλετε γαρνίρετε με άνηθο.</li>\n</ol>'),
(26, 'Κοτοσαλάτα με χρωματιστά ζυμαρικά', 'http://192.168.1.3:8081/salates/MeKreatika/kotosalataMeXrwmZumarika', '<ul>\n <li>700 γρ. κοτόπουλο</li>\n <li>1 κρεμμύδι</li>\n <li>2 καρότα</li>\n <li>250 γρ. πένες τρίχρωμες</li>\n <li>300 γρ. γιαούρτι στραγγιστό</li>\n <li>300 γρ. μαγιονέζα</li>\n <li>3-4 αγγουράκια τουρσί</li>\n <li>5 φέτες γαλοπούλα ή ζαμπόν</li>\n <li', '<ol>\n<li>Βάζουμε το κοτόπουλο σε κατσαρόλα μαζί με το κρεμμύδι, τα καρότα, το αλατοπίπερο και νερό τόσο όσο να το σκεπάζει, και βράζουμε ώσπου να ξεκολλάει από τα κόκαλα και να είναι έτοιμο.</li>\n<li>Καθαρίζουμε το κοτόπουλο από τις πέτσες και τα κόκαλα και το ψιλοκόβουμε μαζί με τα καρότα.</li>\n<li>Σουρώνουμε το ζουμί από το κοτόπουλο και βράζουμε τις πένες. Μόλις βράσουν τις ανακατεύουμε με το λάδι.</li>\n<li>Σε ένα μπολ αναμιγνύουμε το κοτόπουλο, τα καρότα, τις πένες, τα αγγουράκια ψιλοκομμένα, τις φέτες γαλοπούλας ψιλοκομμένες και το μαιντανό. Στο τέλος ρίχνουμε τη μαγιονέζα και το γιαο'),
(27, 'Μεξικάνικη σαλάτα με μπέικον και καλαμπό', 'http://192.168.1.3:8081/salates/MeKreatika/mexikanikiSalata', '<ul>\n <li>1 κονσέρβα μαύρα ή κόκκινα φασόλια</li>\n <li>1 κονσέρβα καλαμπόκι</li>\n <li>1/2 μαρούλι ψιλοκομμένο</li>\n <li>1 πράσινη, 1 κόκκινη, 1 κίτρινη πιπεριάο</li>\n <li>2 - 3 κρεμμυδάκια φρέσκα</li>\n <li>150 γρ. μπέικον</li>\n <li>7-8 ελιές περίπο', '<ol>\n<li> Ψιλοκόβουμε το μαρούλι και τα φρέσκα κρεμμυδάκια. Τις πιπεριές τις κόβουμε σε μακρόστενα κομματάκια.</li>\n<li>Ξεπλένουμε καλά σε σουρωτήρι τα φασόλια και το καλαμπόκι από τα υγρά της κονσέρβας.</li>\n<li>Τσιγαρίζουμε το μπέικον χωρίς λάδι σε αντικολλητικό τηγάνι και το βγάζουμε σε απορροφητικό χαρτί να βγάλει ό,τι τυχόν λάδι έχει (να είναι δηλαδή εντελώς στεγνό).</li>\n<li>Ανακατεύουμε όλα τα υλικά μαζί σε βαθιά διάφανη σαλατιέρα.</li>\n<li>Ανακατεύουμε τη μαγιονέζα με την κέτσαπ σε ένα μπωλάκι χωριστά και προσθέτουμε το ταμπάσκο δοκιμάζοντας ενδιάμεσα για να βγει όσο καυτερό το θέ'),
(31, 'Σαλάτα γλυστρίδας', 'http://192.168.1.3:8081/salates/MeLaxanika/salataGlustridas', '<ul>\n <li>4 μέτριες ντομάτες κομμένες σε μικρά κομμάτια</li>\n <li>1/2 φλυτζάνι φύλλα γλυστρίδας</li>\n <li>1 μέτριο κρεμμύδι κομμένο σαν για χωριάτικη σαλάτα</li>\n <li>παρθένο ελαιόλαδο</li>\n <li>αλάτι</li>\n</ul>', '<ol>\n<li> Πλένουμε τα φύλλα της γλυστρίδας και, μέσα σε μπολ, την αναμειγνύουμε με την ντομάτα και το κρεμμύδι, ντρεσάρουμε με το ελαιόλαδο και προσθέτουμε αλάτι κατά βούληση.</li>\n</ol>'),
(32, 'Γλυκόξινη σαλάτα', 'http://192.168.1.3:8081/salates/MeLaxanika/glukoxiniSalata', '<ul>\n <li>150γρ. σπανάκι</li>\n <li>150γρ. ρόκα</li>\n <li>1κ.σ. ελαιόλαδο</li>\n <li>1κ.σ. ξύδι βαλσάμικο</li>\n <li>1κ.γλ. μουστάρδα</li>\n <li>μικρά κομμάτια παστέλι<li>\n <li>φλύδες παρμεζάνας</li>\n</ul>', '<ol>\n<li>Κόβουμε σε χοντρά κομμάτια τη ρόκα και το σπανάκι</li>\n<li>Σπάμε το παστέλι σε κομματάκια</li>\n<li>Ανακατέβουμε το λάδι με το ξύδι και τη μουστάρδα σε ενα ποτηράκι</li>\n<li>Τέλος τα βάζουμε όλα μαζί σε ένα μπόλ (ρόκα, σπανάκι, παρμεζάνα και το μίγμα μουστάρδας) και σερβίρουμε.</li>\n</ol>'),
(37, 'Μακαρονοτονοσαλάτα', 'http://192.168.1.3:8081/salates/MeThalassina/makaronotonosalata', '<ul>\n <li>500γρ ζυμαρικό βίδες</li>\n <li>1 τόνος σε νερό</li>\n <li>2 φλ. τσ. καλαμπόκι</li>\n <li>2 πιπεριές φλωρίνης</li>\n <li>1 αγγούρι</li>\n <li>1 φλ.τσ. μαγιονέζα<li>\n <li>άνιθο</li>\n</ul>', '<ol>\n<li>Βράζουμε τα ζυμαρικά σε μπόλικο αλατισμένο νερό ,μόλις τα σουρώσουμε, τα αφήνουμε λίγο στην άκρη να κρυώσουν ελαφρά.</li>\n<li>Βράζουμε το καλαμπόκι αν έιναι κατεψυγμένο, διαφορετικά αν χρησιμοποιήσουμε κονσέρβα το βάζουμε σε ένα μεγάλο μπολ με τις πιπεριές και το αγγούρι κομμένα σε μικρά κυβάκια.</li>\n<li>Προσθέτουμε τα μακαρόνια, τον άνηθο, το αλατοπίπερο και τη μαγιονέζα.Ανακατεύουμε καλά και βάζουμε το μπολ σκεπασμένο στο ψυγείο για τουλάχιστον 1 ώρα.</li>\n</ol>'),
(38, 'Πολύχρωμη σαλάτα με τόνο και μήλο', 'http://192.168.1.3:8081/salates/MeThalassina/poluxrwmiMeTono', '<ul>\n <li>1 μαρούλι μέτριο καλά πλυμένο και χοντροκομμένο</li>\n <li>1 μεγάλο και σκληρό μήλο, γλυκό ή ξυνόμηλο</li>\n <li>1 έγχρωμη πιπεριά (κόκκινη, πορτοκαλί ή κίτρινη) κομμένη σε κύβους μέτριου μεγέθους</li>\n <li>10 περίπου τοματάκια κομμένα στη μέσ', '<ol>\n<li>Σε ένα πολύ βαθύ σκεύος ρίχνουμε 4-5 κ.σ. σως βινεγκρέτ.</li>\n<li>Πλένουμε και κόβουμε όλα τα υλικά και τα τοποθετούμε και αυτά στο σκεύος.</li>\n<li>Από πάνω προσθέτουμε ακόμα λίγη σως.</li>\n<li>Ανακατεύουμε απαλά αλλά πολύ καλά για να πάει παντού η βινεγκρέτ.</li>\n<li>Τελευταία αφήνουμε τα κρουτόν και τις φλούδες του τυριού, τα οποία τα τοποθετούμε πάνω πάνω σαν γαρνιτούρα και ραντίζουμε με λίγη σως ακόμα. Όχι πολύ σως για να μην παπαριάσουν τα κρουτόν.</li>\n</ol>');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `subcategory`
--

CREATE TABLE `subcategory` (
  `subid` int(10) NOT NULL,
  `subtitle` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `subimpath` varchar(128) DEFAULT NULL,
  `catid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `subcategory`
--

INSERT INTO `subcategory` (`subid`, `subtitle`, `subimpath`, `catid`) VALUES
(1, 'Ορεκτικά', 'http://192.168.1.3:8081/orektika', 0),
(2, 'Σαλάτες', 'http://192.168.1.3:8081/salates', 0),
(3, 'Κυρίως Πιάτα', 'http://192.168.1.3:8081/kuriws', 0),
(4, 'Σούπες', 'http://192.168.1.3:8081/soupes', 0),
(5, 'Γλυκά', 'http://192.168.1.3:8081/gluka', 0),
(6, 'Με κρεατικά', 'http://192.168.1.3:8081/orektikaMeKreatika', 1),
(7, 'Με λαχανικά', 'http://192.168.1.3:8081/orektikaMeLaxanika', 1),
(8, 'Με θαλασσινά', 'http://192.168.1.3:8081/orektikaMeThalassina', 1),
(9, 'Πίτες', 'http://192.168.1.3:8081/orektikaPites', 1),
(10, 'Διάφορα', 'http://192.168.1.3:8081/orektikaDiafora', 1),
(11, 'Με κρεατικά', 'http://192.168.1.3:8081/salatesMeKreatika', 2),
(12, 'Με λαχανικά', 'http://192.168.1.3:8081/salatesMeLaxanika', 2),
(13, 'Με θαλασσινά', 'http://192.168.1.3:8081/salatesMeThalassina', 2),
(14, 'Με ζυμαρικά', 'http://192.168.1.3:8081/salatesMeZumarika', 2),
(15, 'Διάφορες', 'http://192.168.1.3:8081/salatesDiafores', 2),
(16, 'Με κρεατικά', 'http://192.168.1.3:8081/kuriwsMeKreatika', 3),
(17, 'Με λαχανικά', 'http://192.168.1.3:8081/kuriwsMeLaxanika', 3),
(18, 'Με θαλασσινά', 'http://192.168.1.3:8081/kuriwsMeThalassina', 3),
(19, 'Με ζυμαρικά', 'http://192.168.1.3:8081/kuriwsMeZumarika', 3),
(20, 'Όσπρια', 'http://192.168.1.3:8081/kuriwsMeOspria', 3),
(21, 'Με κρεατικά', 'http://192.168.1.3:8081/soupesMeKreatika', 4),
(22, 'Με λαχανικά', 'http://192.168.1.3:8081/soupesMeLaxanika', 4),
(23, 'Με θαλασσινά', 'http://192.168.1.3:8081/soupesMeThalassina', 4),
(24, 'Με ζυμαρικά', 'http://192.168.1.3:8081/soupesMeZumarika', 4),
(25, 'Όσπρια', 'http://192.168.1.3:8081/soupesMeOspria', 4),
(26, 'Ζύμης', '', 5),
(27, 'Σιροπιαστά', '', 5),
(28, 'Παγωτά', '', 5),
(29, 'Ψυγείου', '', 5),
(30, 'Με φρούτα', '', 5);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `s_r`
--

CREATE TABLE `s_r` (
  `subid` int(11) NOT NULL,
  `rid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `s_r`
--

INSERT INTO `s_r` (`subid`, `rid`) VALUES
(1, 0),
(2, 0),
(3, 0),
(4, 0),
(5, 0),
(6, 1),
(6, 2),
(7, 6),
(7, 7),
(8, 11),
(8, 12),
(9, 0),
(10, 0),
(11, 26),
(11, 27),
(12, 31),
(12, 32),
(13, 37),
(13, 38),
(14, 0),
(15, 0),
(16, 0),
(17, 0),
(18, 0),
(19, 0),
(20, 0),
(21, 0),
(22, 0),
(23, 0),
(24, 0),
(25, 0),
(26, 0),
(27, 0),
(28, 0),
(29, 0),
(30, 0);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `user`
--

CREATE TABLE `user` (
  `uemail` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `user`
--

INSERT INTO `user` (`uemail`) VALUES
('eua@mariou.com'),
('marios@gol.com'),
('simple@user.com');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `u_s`
--

CREATE TABLE `u_s` (
  `uemail` varchar(40) NOT NULL,
  `subid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `u_s`
--

INSERT INTO `u_s` (`uemail`, `subid`) VALUES
('eua@mariou.com', 1),
('eua@mariou.com', 2),
('eua@mariou.com', 3),
('eua@mariou.com', 4),
('eua@mariou.com', 5),
('eua@mariou.com', 6),
('eua@mariou.com', 7),
('eua@mariou.com', 8),
('eua@mariou.com', 9),
('eua@mariou.com', 10),
('eua@mariou.com', 11),
('eua@mariou.com', 12),
('eua@mariou.com', 13),
('eua@mariou.com', 14),
('eua@mariou.com', 15),
('eua@mariou.com', 16),
('eua@mariou.com', 17),
('eua@mariou.com', 18),
('eua@mariou.com', 19),
('eua@mariou.com', 20),
('eua@mariou.com', 21),
('eua@mariou.com', 22),
('eua@mariou.com', 23),
('eua@mariou.com', 24),
('eua@mariou.com', 25),
('eua@mariou.com', 26),
('eua@mariou.com', 27),
('eua@mariou.com', 28),
('eua@mariou.com', 29),
('eua@mariou.com', 30),
('marios@gol.com', 1),
('marios@gol.com', 2),
('marios@gol.com', 3),
('marios@gol.com', 4),
('marios@gol.com', 5),
('marios@gol.com', 6),
('marios@gol.com', 7),
('marios@gol.com', 8),
('marios@gol.com', 9),
('marios@gol.com', 10),
('marios@gol.com', 11),
('marios@gol.com', 12),
('marios@gol.com', 13),
('marios@gol.com', 14),
('marios@gol.com', 15),
('marios@gol.com', 16),
('marios@gol.com', 17),
('marios@gol.com', 18),
('marios@gol.com', 19),
('marios@gol.com', 20),
('marios@gol.com', 21),
('marios@gol.com', 22),
('marios@gol.com', 23),
('marios@gol.com', 24),
('marios@gol.com', 25),
('marios@gol.com', 26),
('marios@gol.com', 27),
('marios@gol.com', 28),
('marios@gol.com', 29),
('marios@gol.com', 30),
('simple@user.com', 1),
('simple@user.com', 2),
('simple@user.com', 3),
('simple@user.com', 4),
('simple@user.com', 5),
('simple@user.com', 6),
('simple@user.com', 7),
('simple@user.com', 8),
('simple@user.com', 9),
('simple@user.com', 10),
('simple@user.com', 11),
('simple@user.com', 12),
('simple@user.com', 13),
('simple@user.com', 14),
('simple@user.com', 15),
('simple@user.com', 16),
('simple@user.com', 17),
('simple@user.com', 18),
('simple@user.com', 19),
('simple@user.com', 20),
('simple@user.com', 21),
('simple@user.com', 22),
('simple@user.com', 23),
('simple@user.com', 24),
('simple@user.com', 25),
('simple@user.com', 26),
('simple@user.com', 27),
('simple@user.com', 28),
('simple@user.com', 29),
('simple@user.com', 30);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `authenticuser`
--
ALTER TABLE `authenticuser`
  ADD PRIMARY KEY (`email`);

--
-- Ευρετήρια για πίνακα `a_f`
--
ALTER TABLE `a_f`
  ADD PRIMARY KEY (`email`,`qid`),
  ADD KEY `qid` (`qid`);

--
-- Ευρετήρια για πίνακα `faqs`
--
ALTER TABLE `faqs`
  ADD PRIMARY KEY (`qid`);

--
-- Ευρετήρια για πίνακα `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`email`,`rid`),
  ADD KEY `rid` (`rid`);

--
-- Ευρετήρια για πίνακα `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`rid`);

--
-- Ευρετήρια για πίνακα `subcategory`
--
ALTER TABLE `subcategory`
  ADD PRIMARY KEY (`subid`);

--
-- Ευρετήρια για πίνακα `s_r`
--
ALTER TABLE `s_r`
  ADD PRIMARY KEY (`subid`,`rid`),
  ADD KEY `rid` (`rid`);

--
-- Ευρετήρια για πίνακα `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uemail`);

--
-- Ευρετήρια για πίνακα `u_s`
--
ALTER TABLE `u_s`
  ADD PRIMARY KEY (`uemail`,`subid`),
  ADD KEY `u_s_ibfk_2` (`subid`);

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `authenticuser`
--
ALTER TABLE `authenticuser`
  ADD CONSTRAINT `authenticuser_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`uemail`);

--
-- Περιορισμοί για πίνακα `a_f`
--
ALTER TABLE `a_f`
  ADD CONSTRAINT `a_f_ibfk_1` FOREIGN KEY (`qid`) REFERENCES `faqs` (`qid`),
  ADD CONSTRAINT `a_f_ibfk_2` FOREIGN KEY (`email`) REFERENCES `authenticuser` (`email`);

--
-- Περιορισμοί για πίνακα `favorite`
--
ALTER TABLE `favorite`
  ADD CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `recipe` (`rid`),
  ADD CONSTRAINT `favorite_ibfk_2` FOREIGN KEY (`email`) REFERENCES `authenticuser` (`email`);

--
-- Περιορισμοί για πίνακα `s_r`
--
ALTER TABLE `s_r`
  ADD CONSTRAINT `s_r_ibfk_1` FOREIGN KEY (`subid`) REFERENCES `subcategory` (`subid`),
  ADD CONSTRAINT `s_r_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `recipe` (`rid`);

--
-- Περιορισμοί για πίνακα `u_s`
--
ALTER TABLE `u_s`
  ADD CONSTRAINT `u_s_ibfk_1` FOREIGN KEY (`uemail`) REFERENCES `user` (`uemail`),
  ADD CONSTRAINT `u_s_ibfk_2` FOREIGN KEY (`subid`) REFERENCES `subcategory` (`subid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
