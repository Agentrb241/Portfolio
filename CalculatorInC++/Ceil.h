#ifndef __CEIL_H__
#define __CEIL_H__

#include "Decorator.h"
#include "base.h"


class Ceil : public Decorator {
    public:
        /* Constructors */
       Ceil(Base* x);

        std::string stringify();
        double evaluate();
};

#endif
