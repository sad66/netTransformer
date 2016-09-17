//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.17 at 09:54:13 AM EEST 
//


package net.itransformers.ideas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.itransformers.ideas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Strategies_QNAME = new QName("", "strategies");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.itransformers.ideas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StrategiesType }
     * 
     */
    public StrategiesType createStrategiesType() {
        return new StrategiesType();
    }

    /**
     * Create an instance of {@link BusinessConstraintType }
     * 
     */
    public BusinessConstraintType createBusinessConstraintType() {
        return new BusinessConstraintType();
    }

    /**
     * Create an instance of {@link StepType }
     * 
     */
    public StepType createStepType() {
        return new StepType();
    }

    /**
     * Create an instance of {@link BusinessConstraintsType }
     * 
     */
    public BusinessConstraintsType createBusinessConstraintsType() {
        return new BusinessConstraintsType();
    }

    /**
     * Create an instance of {@link StrategyType }
     * 
     */
    public StrategyType createStrategyType() {
        return new StrategyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StrategiesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "strategies")
    public JAXBElement<StrategiesType> createStrategies(StrategiesType value) {
        return new JAXBElement<StrategiesType>(_Strategies_QNAME, StrategiesType.class, null, value);
    }

}
