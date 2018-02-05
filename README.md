## CS361 Foundations of Security. Assignment 5 (Markov process) [![MIT license](https://img.shields.io/badge/license-MIT-lightgrey.svg)](https://https://raw.githubusercontent.com/qirh/CS361-assignment5/master/LICENSE)

### Description
Java project by me and [@Ovais](https://github.com/theBrovais). Done for CS f361, taught by the amazing [Dr. Bill Young](https://www.cs.utexas.edu/~byoung/) in the summer of 2016. For assignment details, please look [here](https://github.com/qirh/CS361-assignment5/blob/master/assignment-5.pdf)

**There are 3 java files:** 
* Saleh worked on *Reader.Java*
* we used *jcrypt.Java* from the webpage
* and in *Crack.Java* I worked on the hard mangled cracks and Saleh worked on the easy mangled cracks. 

The cracks were split in this way so that the cracks that take longer are the last things we try. The assignment can be executed by java PasswordCrack inputFile1 inputFile2 where inputFile1 is the dictionary and inputFile2 is a list of passwords to crack after compiling it with javac *.java.

### Finish
We found 3/20 on passwd1 in time 249 seconds. We found 4/20 on passwd2 in time 300 seconds.

### Test Case 1

* **Input**

        michael:atbWfKL4etk4U:500:500:Michael Ferris:/home/michael:/bin/bash
        abigail:&i4KZ5wmac566:501:501:Abigail Smith:/home/abigail:/bin/tcsh
        samantha:(bUx9LiAcW8As:502:502:Samantha Connelly:/home/samantha:/bin/bash
        tyler:<qt0.GlIrXuKs:503:503:Tyler Jones:/home/tyler:/bin/tcsh
        alexander:feohQuHOnMKGE:504:504:Alexander Brown:/home/alexander:
        james:{ztmy9azKzZgU:505:505:James Dover:/home/james:/bin/bash
        benjamin:%xPBzF/TclHvg:506:506:Benjamin Ewing:/home/benjamin:/bin/bash
        morgan:khnVjlJN3Lyh2:507:507:Morgan Simmons:/home/morgan:/bin/bash
        jennifer:e4DBHapAtnjGk:508:508:Jennifer Elmer:/home/jennifer:/bin/bash
        nicole:7we09tBSVT76o:509:509:Nicole Rizzo:/home/nicole:/bin/tcsh
        evan:3dIJJXzELzcRE:510:510:Evan Whitney:/home/evan:/bin/bash
        jack:jsQGVbJ.IiEvE:511:511:Jack Gibson:/home/jack:/bin/bash
        victor:w@EbBlXGLTue6:512:512:Victor Esperanza:/home/victor:
        caleb:8joIBJaXJvTd2:513:513:Caleb Patterson:/home/caleb:/bin/bash
        nathan:nxsr/UAKmKnvo:514:514:Nathan Moore:/home/nathan:/bin/ksh
        connor:gwjT8yTnSCVQo:515:515:Connor Larson:/home/connor:/bin/bash
        rachel:KelgNcBOZdHmA:516:516:Rachel Saxon:/home/rachel:/bin/bash
        dustin:5WW698tSZJE9I:517:517:Dustin Hart:/home/dustin:/bin/csh
        maria:!cI6tOT/9D2r6:518:518:Maia Salizar:/home/maria:/bin/zsh
        paige:T8jwuve9rQBo.:519:519:Paige Reiser:/home/paige:/bin/bash

* **Output**: In total, we cracked 13/20 passwords in time 200 seconds. We however could not crack the last 7/20 passwords, within the same time constraint. Uncracked passwords (caleb, nathan, connor, rachel, dustin, maria, paige)

        User: michael Password: michael Time: 0 Seconds
        User: abigail Password: liagiba Time: 0 Seconds
        User: samantha Password: amazing Time: 0 Seconds
        User: tyler Password: eeffoc Time: 3 Seconds
        User: alexander Password: squadro Time: 13 Seconds
        User: james Password: icious Time: 25 Seconds
        User: benjamin Password: abort6 Time: 37 Seconds
        User: morgan Password: rdoctor Time: 98 Seconds
        User: jennifer Password: doorrood Time: 102 Seconds
        User: nicole Password: keyskeys Time: 108 Seconds
        User: evan Password: Impact Time: 113 Seconds
        User: jack Password: sATCHEL Time: 122 Seconds
        User: victor Password: THIRTY Time: 132 Seconds


### Test Case 2
* **Input**

        michael:atQhiiJLsT6cs:500:500:Michael Ferris:/home/michael:/bin/bash
        abigail:&ileDTgJtzCRo:501:501:Abigail Smith:/home/abigail:/bin/tcsh
        samantha:(bt0xiAwCf7nA:502:502:Samantha Connelly:/home/samantha:/bin/bash
        tyler:<qf.L9z1/tZkA:503:503:Tyler Jones:/home/tyler:/bin/tcsh
        alexander:fe8PnYhq6WoOQ:504:504:Alexander Brown:/home/alexander:
        james:{zQOjvJcHMs7w:505:505:James Dover:/home/james:/bin/bash
        benjamin:%xqFrM5RVA6t6:506:506:Benjamin Ewing:/home/benjamin:/bin/bash
        morgan:kh/1uC5W6nDKc:507:507:Morgan Simmons:/home/morgan:/bin/bash
        jennifer:e4EyEMhNzYLJU:508:508:Jennifer Elmer:/home/jennifer:/bin/bash
        nicole:7wKTWsgNJj6ac:509:509:Nicole Rizzo:/home/nicole:/bin/tcsh
        evan:3d1OgBYfvEtfg:510:510:Evan Whitney:/home/evan:/bin/bash
        jack:js5ctN1leUABo:511:511:Jack Gibson:/home/jack:/bin/bash
        victor:w@FxBZv.d0y/U:512:512:Victor Esperanza:/home/victor:
        caleb:8jGWbU0xbKz06:513:513:Caleb Patterson:/home/caleb:/bin/bash
        nathan:nxr9OOqvZjbGs:514:514:Nathan Moore:/home/nathan:/bin/ksh
        connor:gw9oXmw1L08RM:515:515:Connor Larson:/home/connor:/bin/bash
        rachel:KenK1CTDGr/7k:516:516:Rachel Saxon:/home/rachel:/bin/bash
        dustin:5Wb2Uqxhoyqfg:517:517:Dustin Hart:/home/dustin:/bin/csh
        maria:!cSaQELm/EBV.:518:518:Maia Salizar:/home/maria:/bin/zsh
        paige:T8U5jQaDVv/o2:519:519:Paige Reiser:/home/paige:/bin/bash

* **Output**: In total, we cracked 4/20 passwords in time 200 seconds. We however could not crack the last 16/20 passwords, within the same time constraint. Uncracked passwords are for (alexander, james, benjamin, morgan, jennifer, nicole, evan, jack, victor, caleb, nathan, connor, rachel, dustin, maria, paige)

        User: michael Password: tremors Time: 1 Seconds
        User: abigail Password: Saxon Time: 24 Seconds
        User: samantha Password: cOnNeLlY Time: 24 Seconds
        User: tyler Password: eltneg Time: 29 Seconds

