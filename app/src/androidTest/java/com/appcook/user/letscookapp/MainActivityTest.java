package com.appcook.user.letscookapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.appcook.user.letscookapp.Controllers.MainActivity;
import com.appcook.user.letscookapp.Model.Category;
import com.appcook.user.letscookapp.Model.SimpleUser;
import com.appcook.user.letscookapp.Model.SubCategory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest{

    private SimpleUser userTemp;

    @Rule
    // third parameter is set to false which means the activity is not started automatically
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule(MainActivity.class);

    @Test
    public void mainActivityView() throws InterruptedException {
        onView(withId(R.id.bguest)).check(matches(withText("Login As Guest")));
        onView(withId(R.id.blogin)).check(matches(withText("Login As User")));
    }

    @Test
    public void mainActivityFetchData() throws InterruptedException {
        rule.getActivity().updateUserGlobalApplication(true);
        Thread.sleep(3000);
        userTemp = (SimpleUser) MainActivity.glApp.simpleUser;
        categories();
        subCategories();
        listOfRecipes();
        recipes();
    }

    public void categories(){
        List<Category> catlist = userTemp.getCategory();
        assertThat((catlist.get(0).getCattitle()), is("Ορεκτικά"));
        assertThat((catlist.get(1).getCattitle()), is("Σαλάτες"));
        assertThat((catlist.get(2).getCattitle()), is("Κυρίως Πιάτα"));
        assertThat((catlist.get(3).getCattitle()), is("Σούπες"));
        assertThat((catlist.get(4).getCattitle()), is("Γλυκά"));
    }

    public void subCategories(){
        List<Category> sublist = userTemp.getCategory().get(0).getSubcategory();
        assertThat((sublist.get(0).getCattitle()), is("Με κρεατικά"));
        assertThat((sublist.get(1).getCattitle()), is("Με λαχανικά"));
        assertThat((sublist.get(2).getCattitle()), is("Με θαλασσινά"));
        assertThat((sublist.get(3).getCattitle()), is("Πίτες"));
        assertThat((sublist.get(4).getCattitle()), is("Διάφορα"));

        sublist = userTemp.getCategory().get(1).getSubcategory();
        assertThat((sublist.get(0).getCattitle()), is("Με κρεατικά"));
        assertThat((sublist.get(1).getCattitle()), is("Με λαχανικά"));
        assertThat((sublist.get(2).getCattitle()), is("Με θαλασσινά"));
        assertThat((sublist.get(3).getCattitle()), is("Με ζυμαρικά"));
        assertThat((sublist.get(4).getCattitle()), is("Διάφορες"));

        sublist = userTemp.getCategory().get(2).getSubcategory();
        assertThat((sublist.get(0).getCattitle()), is("Με κρεατικά"));
        assertThat((sublist.get(1).getCattitle()), is("Με λαχανικά"));
        assertThat((sublist.get(2).getCattitle()), is("Με θαλασσινά"));
        assertThat((sublist.get(3).getCattitle()), is("Με ζυμαρικά"));
        assertThat((sublist.get(4).getCattitle()), is("Όσπρια"));

        sublist = userTemp.getCategory().get(3).getSubcategory();
        assertThat((sublist.get(0).getCattitle()), is("Με κρεατικά"));
        assertThat((sublist.get(1).getCattitle()), is("Με λαχανικά"));
        assertThat((sublist.get(2).getCattitle()), is("Με θαλασσινά"));
        assertThat((sublist.get(3).getCattitle()), is("Με ζυμαρικά"));
        assertThat((sublist.get(4).getCattitle()), is("Όσπρια"));

        sublist = userTemp.getCategory().get(4).getSubcategory();
        assertThat((sublist.get(0).getCattitle()), is("Ζύμης"));
        assertThat((sublist.get(1).getCattitle()), is("Σιροπιαστά"));
        assertThat((sublist.get(2).getCattitle()), is("Παγωτά"));
        assertThat((sublist.get(3).getCattitle()), is("Ψυγείου"));
        assertThat((sublist.get(4).getCattitle()), is("Με φρούτα"));
    }

    public void listOfRecipes(){
        SubCategory cat0_0 = (SubCategory) userTemp.getCategory().get(0).getSubcategory().get(0);
        SubCategory cat0_1 = (SubCategory) userTemp.getCategory().get(0).getSubcategory().get(1);
        SubCategory cat0_2 = (SubCategory) userTemp.getCategory().get(0).getSubcategory().get(2);

        SubCategory cat1_0 = (SubCategory) userTemp.getCategory().get(1).getSubcategory().get(0);
        SubCategory cat1_1 = (SubCategory) userTemp.getCategory().get(1).getSubcategory().get(1);
        SubCategory cat1_2 = (SubCategory) userTemp.getCategory().get(1).getSubcategory().get(2);

        assertThat((cat0_0.getRecipe().get(0).getRtitle()), is("Γεμιστά ρολάκια κιμά"));
        assertThat((cat0_0.getRecipe().get(1).getRtitle()), is("Κοτομπουκιές πανέ στο φούρνο"));
        assertThat((cat0_1.getRecipe().get(0).getRtitle()), is("Muffins με κολοκυθάκια"));
        assertThat((cat0_1.getRecipe().get(1).getRtitle()), is("Γεμιστό Αβοκάντο"));
        assertThat((cat0_2.getRecipe().get(0).getRtitle()), is("Γαρίδες λεμονάτες με πιπεριές"));
        assertThat((cat0_2.getRecipe().get(1).getRtitle()), is("Καναπεδάκια με μους σολομού"));

        assertThat((cat1_0.getRecipe().get(0).getRtitle()), is("Κοτοσαλάτα με χρωματιστά ζυμαρικά"));
        assertThat((cat1_0.getRecipe().get(1).getRtitle()), is("Μεξικάνικη σαλάτα με μπέικον και καλαμπό"));
        assertThat((cat1_1.getRecipe().get(0).getRtitle()), is("Σαλάτα γλυστρίδας"));
        assertThat((cat1_1.getRecipe().get(1).getRtitle()), is("Γλυκόξινη σαλάτα"));
        assertThat((cat1_2.getRecipe().get(0).getRtitle()), is("Μακαρονοτονοσαλάτα"));
        assertThat((cat1_2.getRecipe().get(1).getRtitle()), is("Πολύχρωμη σαλάτα με τόνο και μήλο"));
    }

    public void recipes(){
        SubCategory cat0_0 = (SubCategory) userTemp.getCategory().get(0).getSubcategory().get(0);
        SubCategory cat0_1 = (SubCategory) userTemp.getCategory().get(0).getSubcategory().get(1);
        SubCategory cat0_2 = (SubCategory) userTemp.getCategory().get(0).getSubcategory().get(2);

        SubCategory cat1_0 = (SubCategory) userTemp.getCategory().get(1).getSubcategory().get(0);
        SubCategory cat1_1 = (SubCategory) userTemp.getCategory().get(1).getSubcategory().get(1);
        SubCategory cat1_2 = (SubCategory) userTemp.getCategory().get(1).getSubcategory().get(2);

        assertThat((cat0_0.getRecipe().get(0).getRtitle()), is("Γεμιστά ρολάκια κιμά"));
        assertThat((cat0_0.getRecipe().get(0).getMdesc()), is("1. 1 κιλό κιμά (ανάμικτο μοσχαρίσιο και χοιρινό)\n" +
                "2. 1 μεγάλο κρεμμύδι\n" +
                "3. 3 σκελίδες σκόρδο λειωμένο\n" +
                "4. 1 ματσάκι μαϊντανό\n" +
                "5. 2 αυγά\n" +
                "6. 2 φρυγανιές\n" +
                "7. 1 1/2 κουταλάκι αλάτι\n" +
                "8. Πιπέρι\n" +
                "9. 80 ml άσπρο κρασί\n" +
                "10. 2 αυγά για το πανάρισμα\n" +
                "11. τυρί ρεγκάτο ή γραβι"));
        assertThat((cat0_0.getRecipe().get(0).getSteps()), is("1.\tΤρίβουμε τα παξιμαδάκια χτυπάμε το κρεμμύδι με το μαϊντανό και τα αυγά και ανακατεύουμε καλά όλα τα υλικά μαζί.\n" +
                "2.\tΚόβουμε το τυρί σε μπαστουνάκια.\n" +
                "3.\tΚόβουμε το ζαμπόν σε λωρίδες.\n" +
                "4.\tΧτυπάμε σε μπολ τα αυγά με νερό για το πανάρισμα.\n" +
                "5.\tΧτυπάμε τα "));

        assertThat((cat0_0.getRecipe().get(1).getRtitle()), is("Κοτομπουκιές πανέ στο φούρνο"));
        assertThat((cat0_0.getRecipe().get(1).getMdesc()), is("<ul>\n" +
                " <li>700 γρ. κοτόπουλο στήθος φιλέτο</li>\n" +
                " <li>70 γρ. γαλέτα</li>\n" +
                " <li>70 γρ. παρμεζάνα</li>\n" +
                " <li>1/2 φλιτζάνι ελαιόλαδο</li>\n" +
                " <li>το χυμό ενός λεμονιού</li>\n" +
                " <li>1 κ.γ. μουστάρδα</li>\n" +
                " <li>αλάτι</li>\n" +
                " <li>πιπέρι φρεσκοτριμμένο</li>\n" +
                "</ul>"));
        assertThat((cat0_0.getRecipe().get(1).getSteps()), is("<ol>\n" +
                "<li>Κόβουμε το φιλέτο σε μπουκιές.</li>\n" +
                "<li>Σε ένα μπολ βάζουμε το λάδι, το λεμόνι, την μουστάρδα, το αλάτι και τέλος το πιπέρι και χτυπάμε να ομογενοποιηθεί το μείγμα.</li>\n" +
                "<li>Σε ένα άλλο μπολ βάζουμε την γαλέτα με την παρμεζάνα.</li>\n" +
                "<li>Βουτάμε τις μπουκίτσες στο λαδολέμονο και μετά στο μείγμα γαλέτας-παρμεζάνας.</li>\n" +
                "<li>Βάζουμε στο ταψί μας λαδόκολλα και τοποθετούμε τις κοτομπουκιές την μία δίπλα στην άλλη χωρίς να ακουμπάνε.</li>\n" +
                "<li>Βάζω σε προθερμασμένο φούρνο στους 180ο θερμό αέρα στην 2η θέση από κάτω και ψήνω για 20 λεπτά.</li>\n" +
                "</ol>"));

        assertThat((cat0_1.getRecipe().get(0).getRtitle()), is("Muffins με κολοκυθάκια"));
        assertThat((cat0_1.getRecipe().get(0).getMdesc()), is("<ul>\n" +
                " <li>2 - 3 κολοκυθάκια τριμμένα</li>\n" +
                " <li>150 γρ. γιαούρτι στραγγιστό</li>\n" +
                " <li>2 αυγά χτυπημένα</li>\n" +
                " <li>1/2 ποτήρι καλαμποκέλαιο</li>\n" +
                " <li>1 ποτήρι αλεύρι που φουσκώνει μόνο του</li>\n" +
                " <li>150 γρ. φέτα τριμμένη</li>\n" +
                " <li>αλάτι</li>\n" +
                " <li>1-2"));
        assertThat((cat0_1.getRecipe().get(0).getSteps()), is("<ol>\n" +
                "<li>Αναμιγνύουμε όλα τα υλικά μαζί και κάνουμε ένα πηχτό χυλό.</li>\n" +
                "<li>Λαδώνουμε καλά τις υποδοχές για τα muffins (ταψάκια για muffins) ή τα χαρτάκια για muffins και πασπαλίζουμε με φρυγανιά.</li>\n" +
                "<li>Ρίχνουμε στις υποδοχές 2 - 3 κουταλιές απo το μείγμα και τα ψήνουμε στους 180 βαθμούς μέχρι να ροδίσει όλη τους η επιφάνεια (περίπου 50 λεπτά ανάλογα το φούρνο).</li>\n" +
                "</ol>"));

        assertThat((cat0_1.getRecipe().get(1).getRtitle()), is("Γεμιστό Αβοκάντο"));
        assertThat((cat0_1.getRecipe().get(1).getMdesc()), is("<ul>\n" +
                " <li>1 Αβοκάντο</li>\n" +
                " <li>1 Ντομάτα</li>\n" +
                " <li>1 Αγγουράκι</li>\n" +
                " <li>1 Κούπα γιαουρτι</li>\n" +
                " <li>1 Κουτάλι σούπας ψιλοκομμένο φρέσκο κρεμμύδι</li>\n" +
                " <li>Φρέσκο μαϊντανό ψιλοκομμένο για γαρνίρισμα</li>\n" +
                " <li>Μια πρεζα αλάτι</li>\n" +
                "</ul>"));
        assertThat((cat0_1.getRecipe().get(1).getSteps()), is("<ol>\n" +
                "<li> Κόβουμε το Αβοκάντο στη μέση και με ενα κουτάλι αφαιρούμε προσεκτικά τη σάρκα.</li>\n" +
                "<li>Σε μπώλ βαζουμε τη ντομάτα και το αγγουράκι, αφού τα έχουμε ψιλοκόψει.</li>\n" +
                "<li>Προσθέτουμε την σάρκα του αβοκάντο, το φρέσκο κρεμμυδάκι και το γιαουρτι.</li>\n" +
                "<li>Αλατίζουμε και ανακατεύουμε.</li>\n" +
                "<li>Με ενα κουτάλι γεμίζουμε τα μισά του αβοκάντο, πασπαλίζουμε με ψιλοκομμένο μαϊντανό και σερβίρουμε.</li>\n" +
                "</ol>"));

        assertThat((cat0_2.getRecipe().get(0).getRtitle()), is("Γαρίδες λεμονάτες με πιπεριές"));
        assertThat((cat0_2.getRecipe().get(0).getMdesc()), is("<ul>\n" +
                " <li>500 γρ γαρίδες μεσαίες</li>\n" +
                " <li>100 γρ νερό ζεστό</li>\n" +
                " <li>1 συμπυκνωμένος ζωμός λαχανικών</li>\n" +
                " <li>100 γρ ελαιόλαδο</li>\n" +
                " <li>3 σκελίδες σκόρδο σε φέτες</li>\n" +
                " <li>30 γρ χυμός λεμονιού</li>\n" +
                " <li>2 κουτ σούπας μαϊντανός ψιλοκομμένος</li"));
        assertThat((cat0_2.getRecipe().get(0).getSteps()), is("<ol>\n" +
                "<li> Ξεπλένουμε καλά τις γαρίδες και τις αφήνουμε να στραγγίξουν σε τρυπητό σκεύος.</li>\n" +
                "<li>Σε ένα μπλέντερ αναμιγνύουμε το νερό, τον ζωμό και το ελαιόλαδο μέχρι να διαλυθεί ο ζωμός..</li>\n" +
                "<li>Ρίχνουμε το μίγμα σε ένα βαθύ τηγάνι και προσθέτουμε το σκόρδο, το χυμό λεμονιού, το μαϊντανό και τις πιπεριές.</li>\n" +
                "<li>Βράζουμε για 2 λεπτά περίπου και κατόπιν προσθέτουμε τις γαρίδες, αλατίζοντάς τες ελαφρά.</li>\n" +
                "<li>Τέλος, προσθέτουμε τη μουστάρδα και αφήνουμε να βράσει για ακόμα 3 λεπτά περίπου, ανακατεύοντας με απαλές κινήσεις.</li>\n" +
                "<li>Αποσύρουμε από την φωτιά και σερβίρουμε αμέσως.</l"));

        assertThat((cat0_2.getRecipe().get(1).getRtitle()), is("Καναπεδάκια με μους σολομού"));
        assertThat((cat0_2.getRecipe().get(1).getMdesc()), is("<ul>\n" +
                " <li>100 γρ. καπνιστό σολομό</li>\n" +
                " <li>100 γρ. τυρί κρέμα</li>\n" +
                " <li>1 κ.γ. μαγιονέζα</li>\n" +
                " <li>άνηθο όσο θέλετε</li>\n" +
                " <li>λιγο λεμόνι</li>\n" +
                " <li>φρυγανισμένο ψωμί του τοστ σε τέταρτα</li>\n" +
                "</ul>"));
        assertThat((cat0_2.getRecipe().get(1).getSteps()), is("<ol>\n" +
                "<li> Πολτοποιείτε όλα τα υλικά - πλην του ψωμιού - σε μούλτι.</li>\n" +
                "<li>Αλείφετε το ψωμί και αν θέλετε γαρνίρετε με άνηθο.</li>\n" +
                "</ol>"));

        assertThat((cat1_0.getRecipe().get(0).getRtitle()), is("Κοτοσαλάτα με χρωματιστά ζυμαρικά"));
        assertThat((cat1_0.getRecipe().get(0).getMdesc()), is("<ul>\n" +
                " <li>700 γρ. κοτόπουλο</li>\n" +
                " <li>1 κρεμμύδι</li>\n" +
                " <li>2 καρότα</li>\n" +
                " <li>250 γρ. πένες τρίχρωμες</li>\n" +
                " <li>300 γρ. γιαούρτι στραγγιστό</li>\n" +
                " <li>300 γρ. μαγιονέζα</li>\n" +
                " <li>3-4 αγγουράκια τουρσί</li>\n" +
                " <li>5 φέτες γαλοπούλα ή ζαμπόν</li>\n" +
                " <li"));
        assertThat((cat1_0.getRecipe().get(0).getSteps()), is("<ol>\n" +
                "<li>Βάζουμε το κοτόπουλο σε κατσαρόλα μαζί με το κρεμμύδι, τα καρότα, το αλατοπίπερο και νερό τόσο όσο να το σκεπάζει, και βράζουμε ώσπου να ξεκολλάει από τα κόκαλα και να είναι έτοιμο.</li>\n" +
                "<li>Καθαρίζουμε το κοτόπουλο από τις πέτσες και τα κόκαλα και το ψιλοκόβουμε μαζί με τα καρότα.</li>\n" +
                "<li>Σουρώνουμε το ζουμί από το κοτόπουλο και βράζουμε τις πένες. Μόλις βράσουν τις ανακατεύουμε με το λάδι.</li>\n" +
                "<li>Σε ένα μπολ αναμιγνύουμε το κοτόπουλο, τα καρότα, τις πένες, τα αγγουράκια ψιλοκομμένα, τις φέτες γαλοπούλας ψιλοκομμένες και το μαιντανό. Στο τέλος ρίχνουμε τη μαγιονέζα και το γιαο"));

        assertThat((cat1_0.getRecipe().get(1).getRtitle()), is("Μεξικάνικη σαλάτα με μπέικον και καλαμπό"));
        assertThat((cat1_0.getRecipe().get(1).getMdesc()), is("<ul>\n" +
                " <li>1 κονσέρβα μαύρα ή κόκκινα φασόλια</li>\n" +
                " <li>1 κονσέρβα καλαμπόκι</li>\n" +
                " <li>1/2 μαρούλι ψιλοκομμένο</li>\n" +
                " <li>1 πράσινη, 1 κόκκινη, 1 κίτρινη πιπεριάο</li>\n" +
                " <li>2 - 3 κρεμμυδάκια φρέσκα</li>\n" +
                " <li>150 γρ. μπέικον</li>\n" +
                " <li>7-8 ελιές περίπο"));
        assertThat((cat1_0.getRecipe().get(1).getSteps()), is("<ol>\n" +
                "<li> Ψιλοκόβουμε το μαρούλι και τα φρέσκα κρεμμυδάκια. Τις πιπεριές τις κόβουμε σε μακρόστενα κομματάκια.</li>\n" +
                "<li>Ξεπλένουμε καλά σε σουρωτήρι τα φασόλια και το καλαμπόκι από τα υγρά της κονσέρβας.</li>\n" +
                "<li>Τσιγαρίζουμε το μπέικον χωρίς λάδι σε αντικολλητικό τηγάνι και το βγάζουμε σε απορροφητικό χαρτί να βγάλει ό,τι τυχόν λάδι έχει (να είναι δηλαδή εντελώς στεγνό).</li>\n" +
                "<li>Ανακατεύουμε όλα τα υλικά μαζί σε βαθιά διάφανη σαλατιέρα.</li>\n" +
                "<li>Ανακατεύουμε τη μαγιονέζα με την κέτσαπ σε ένα μπωλάκι χωριστά και προσθέτουμε το ταμπάσκο δοκιμάζοντας ενδιάμεσα για να βγει όσο καυτερό το θέ"));

        assertThat((cat1_1.getRecipe().get(0).getRtitle()), is("Σαλάτα γλυστρίδας"));
        assertThat((cat1_1.getRecipe().get(0).getMdesc()), is("<ul>\n" +
                " <li>4 μέτριες ντομάτες κομμένες σε μικρά κομμάτια</li>\n" +
                " <li>1/2 φλυτζάνι φύλλα γλυστρίδας</li>\n" +
                " <li>1 μέτριο κρεμμύδι κομμένο σαν για χωριάτικη σαλάτα</li>\n" +
                " <li>παρθένο ελαιόλαδο</li>\n" +
                " <li>αλάτι</li>\n" +
                "</ul>"));
        assertThat((cat1_1.getRecipe().get(0).getSteps()), is("<ol>\n" +
                "<li> Πλένουμε τα φύλλα της γλυστρίδας και, μέσα σε μπολ, την αναμειγνύουμε με την ντομάτα και το κρεμμύδι, ντρεσάρουμε με το ελαιόλαδο και προσθέτουμε αλάτι κατά βούληση.</li>\n" +
                "</ol>"));

        assertThat((cat1_1.getRecipe().get(1).getRtitle()), is("Γλυκόξινη σαλάτα"));
        assertThat((cat1_1.getRecipe().get(1).getMdesc()), is("<ul>\n" +
                " <li>150γρ. σπανάκι</li>\n" +
                " <li>150γρ. ρόκα</li>\n" +
                " <li>1κ.σ. ελαιόλαδο</li>\n" +
                " <li>1κ.σ. ξύδι βαλσάμικο</li>\n" +
                " <li>1κ.γλ. μουστάρδα</li>\n" +
                " <li>μικρά κομμάτια παστέλι<li>\n" +
                " <li>φλύδες παρμεζάνας</li>\n" +
                "</ul>"));
        assertThat((cat1_1.getRecipe().get(1).getSteps()), is("<ol>\n" +
                "<li>Κόβουμε σε χοντρά κομμάτια τη ρόκα και το σπανάκι</li>\n" +
                "<li>Σπάμε το παστέλι σε κομματάκια</li>\n" +
                "<li>Ανακατέβουμε το λάδι με το ξύδι και τη μουστάρδα σε ενα ποτηράκι</li>\n" +
                "<li>Τέλος τα βάζουμε όλα μαζί σε ένα μπόλ (ρόκα, σπανάκι, παρμεζάνα και το μίγμα μουστάρδας) και σερβίρουμε.</li>\n" +
                "</ol>"));

        assertThat((cat1_2.getRecipe().get(0).getRtitle()), is("Μακαρονοτονοσαλάτα"));
        assertThat((cat1_2.getRecipe().get(0).getMdesc()), is("<ul>\n" +
                " <li>500γρ ζυμαρικό βίδες</li>\n" +
                " <li>1 τόνος σε νερό</li>\n" +
                " <li>2 φλ. τσ. καλαμπόκι</li>\n" +
                " <li>2 πιπεριές φλωρίνης</li>\n" +
                " <li>1 αγγούρι</li>\n" +
                " <li>1 φλ.τσ. μαγιονέζα<li>\n" +
                " <li>άνιθο</li>\n" +
                "</ul>"));
        assertThat((cat1_2.getRecipe().get(0).getSteps()), is("<ol>\n" +
                "<li>Βράζουμε τα ζυμαρικά σε μπόλικο αλατισμένο νερό ,μόλις τα σουρώσουμε, τα αφήνουμε λίγο στην άκρη να κρυώσουν ελαφρά.</li>\n" +
                "<li>Βράζουμε το καλαμπόκι αν έιναι κατεψυγμένο, διαφορετικά αν χρησιμοποιήσουμε κονσέρβα το βάζουμε σε ένα μεγάλο μπολ με τις πιπεριές και το αγγούρι κομμένα σε μικρά κυβάκια.</li>\n" +
                "<li>Προσθέτουμε τα μακαρόνια, τον άνηθο, το αλατοπίπερο και τη μαγιονέζα.Ανακατεύουμε καλά και βάζουμε το μπολ σκεπασμένο στο ψυγείο για τουλάχιστον 1 ώρα.</li>\n" +
                "</ol>"));

        assertThat((cat1_2.getRecipe().get(1).getRtitle()), is("Πολύχρωμη σαλάτα με τόνο και μήλο"));
        assertThat((cat1_2.getRecipe().get(1).getMdesc()), is("<ul>\n" +
                " <li>1 μαρούλι μέτριο καλά πλυμένο και χοντροκομμένο</li>\n" +
                " <li>1 μεγάλο και σκληρό μήλο, γλυκό ή ξυνόμηλο</li>\n" +
                " <li>1 έγχρωμη πιπεριά (κόκκινη, πορτοκαλί ή κίτρινη) κομμένη σε κύβους μέτριου μεγέθους</li>\n" +
                " <li>10 περίπου τοματάκια κομμένα στη μέσ"));
        assertThat((cat1_2.getRecipe().get(1).getSteps()), is("<ol>\n" +
                "<li>Σε ένα πολύ βαθύ σκεύος ρίχνουμε 4-5 κ.σ. σως βινεγκρέτ.</li>\n" +
                "<li>Πλένουμε και κόβουμε όλα τα υλικά και τα τοποθετούμε και αυτά στο σκεύος.</li>\n" +
                "<li>Από πάνω προσθέτουμε ακόμα λίγη σως.</li>\n" +
                "<li>Ανακατεύουμε απαλά αλλά πολύ καλά για να πάει παντού η βινεγκρέτ.</li>\n" +
                "<li>Τελευταία αφήνουμε τα κρουτόν και τις φλούδες του τυριού, τα οποία τα τοποθετούμε πάνω πάνω σαν γαρνιτούρα και ραντίζουμε με λίγη σως ακόμα. Όχι πολύ σως για να μην παπαριάσουν τα κρουτόν.</li>\n" +
                "</ol>"));
    }

}