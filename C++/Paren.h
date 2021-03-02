#ifndef __PAREN_H__
#define __PAREN_H__

#include "Decorator.h"
#include "base.h"

class Paren : public Decorator {
    public:
        /* Constructors */
        Paren();


        Paren(Base* Base);
        double evaluate();
        std::string stringify();
};

#endif
